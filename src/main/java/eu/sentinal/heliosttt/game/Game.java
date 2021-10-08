package eu.sentinal.heliosttt.game;

import eu.sentinal.heliosttt.HeliosTTT;
import eu.sentinal.heliosttt.inventories.pojo.ItemUtils;
import eu.sentinal.heliosttt.inventories.pojo.Letter;
import eu.sentinal.heliosttt.utils.pojo.Pair;
import eu.sentinal.heliosttt.utils.pojo.ParameterRunnable;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import static eu.sentinal.heliosttt.game.Mark.*;

public class Game {

    private final Inventory inventory;

    private final Integer[] field = {12, 13, 14, 21, 22, 23, 30, 31, 32};

    private Mark winningMark;
    private final int BOARD_WIDTH = 3;
    private Pair<Player, Mark> turn;
    private boolean gameOver;
    private int availableMoves = BOARD_WIDTH * BOARD_WIDTH;
    private final ItemStack crossStack = new ItemUtils(Letter.RED_X.getItemStack()).addDisplayName("X").build();
    private final ItemStack circleStack = new ItemUtils(Letter.O.getItemStack()).addDisplayName("O").build();
    private final ParameterRunnable<Mark, Player> parameterRunnable;

    private final Player player;
    private Mark playerMark;
    private final Player opponent;
    private Mark opponentMark;

    public Game(Inventory inventory, ParameterRunnable<Mark, Player> parameterRunnable, Player player, Player opponent) {
        this.inventory = inventory;
        this.parameterRunnable = parameterRunnable;
        this.player = player;
        this.opponent = opponent;
        initialiseBoard();
    }

    private void initialiseBoard() {
        this.playerMark = Mark.values()[(new Random()).nextInt(Mark.values().length)];
        this.opponentMark = (playerMark == Mark.CIRCLE ? Mark.CROSS : Mark.CIRCLE);
        for (int row = 1; row < BOARD_WIDTH; row++) {
            for (int col = 1; col < BOARD_WIDTH; col++) {
                setMarkAt(row, col, BLANK);
            }
        }
        if (playerMark == CIRCLE)
            turn = new Pair<>(player, playerMark);
        if (opponentMark == CIRCLE)
            turn = new Pair<>(opponent, opponentMark);
        announceTurn(CIRCLE);
    }

    public void placeMark(int row, int col, Player player) {
        if (row < 0 || row > BOARD_WIDTH || col < 0 || col > BOARD_WIDTH || isTileMarked(row, col) || gameOver) {
            return;
        }
        Mark mark = (this.player == player ? playerMark : opponentMark);
        if (mark == CROSS && turn.getValue() == CIRCLE) {
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 0.2f);
            return;
        }
        if (mark == CIRCLE && turn.getValue() == CROSS) {
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.2f, 0.2f);
            return;
        }
        availableMoves--;
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.2f, 0.2f);
        setMarkAt(row, col, (turn.getValue() == CROSS ? CROSS : CIRCLE));
        togglePlayer();
        checkWinV2();
    }

    public boolean isTileMarked(int row, int column) {
        return getMarkAt(row, column).isMarked();
    }

    private void togglePlayer() {
        turn = new Pair<>((turn.getKey() == player ? opponent : player), (turn.getKey() == player ? opponentMark : playerMark));
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 0.2f, 0.2f);
        announceTurn(turn.getValue());
    }

    private void announceTurn(Mark cross) {
        if (playerMark == cross) {
            player.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.GREEN + "Du bist dran!");
            opponent.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.GOLD + player.getName() + ChatColor.RED + " ist dran!");
        } else {
            opponent.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.GREEN + "Du bist dran!");
            player.sendMessage(HeliosTTT.PLUGIN_PREFIX + ChatColor.GOLD + opponent.getName() + ChatColor.RED + " ist dran!");
        }
    }

    private void checkWinV2() {
        checkWinRow(0, 1, 2);
        checkWinRow(3, 4, 5);
        checkWinRow(6, 7, 8);

        checkWinRow(0, 4, 8);
        checkWinRow(3, 4, 6);

        checkWinRow(0, 3, 6);
        checkWinRow(1, 4, 7);
        checkWinRow(2, 5, 8);

        if (!anyMovesAvailable()) {
            gameOver = true;
            parameterRunnable.run(BLANK, null);
        }

    }

    private void checkWinRow(int index1, int index2, int index3) {
        if(gameOver) return;
        if (inventory.getItem(field[index1]) != null && inventory.getItem(field[index2]) != null && inventory.getItem(field[index3]) != null) {
            // Circle Win?
            if (inventory.getItem(field[index1]).equals(circleStack) && inventory.getItem(field[index2]).equals(circleStack) && inventory.getItem(field[index3]).equals(circleStack)) {
                parameterRunnable.run(CIRCLE, (playerMark == CIRCLE ? player : opponent));
            }

            //Cross Win?
            if (inventory.getItem(field[index1]).equals(crossStack) && inventory.getItem(field[index2]).equals(crossStack) && inventory.getItem(field[index3]).equals(crossStack)) {
                parameterRunnable.run(CROSS, (playerMark == CROSS ? player : opponent));
            }
        }
    }


    public boolean anyMovesAvailable() {
        return availableMoves > 0;
    }

    public void setMarkAt(int row, int column, Mark newMark) {
        BoardSlots slot = Arrays.stream(BoardSlots.values()).filter(f -> f.getRow() == row).filter(f -> f.getColumn() == column).collect(Collectors.toList()).get(0);
        if (slot == null) return;

        ItemStack itemStack = inventory.getItem(slot.getSlot());
        if (itemStack != null)
            if (itemStack.equals(crossStack) || itemStack.equals(circleStack)) return;
        if (newMark == BLANK) {
            inventory.setItem(slot.getSlot(), new ItemStack(Material.AIR));
        } else {
            inventory.setItem(slot.getSlot(), (newMark == CIRCLE ? circleStack : crossStack));
        }
    }

    public Mark getMarkAt(int row, int column) {
        if (Arrays.stream(BoardSlots.values()).noneMatch(p -> p.getRow() == row && p.getColumn() == column))
            return BLANK;
        BoardSlots slot = Arrays.stream(BoardSlots.values()).filter(f -> f.getRow() == row).filter(f -> f.getColumn() == column).collect(Collectors.toList()).get(0);
        if (slot == null) return BLANK;

        ItemStack itemStack = inventory.getItem(slot.getSlot());
        if (itemStack == null || !itemStack.hasItemMeta()) return BLANK;

        ItemMeta itemMeta = itemStack.getItemMeta();
        if (!itemMeta.hasDisplayName()) return BLANK;

        if (itemMeta.getDisplayName().equals("X")) return CROSS;
        if (itemMeta.getDisplayName().equals("O")) return CIRCLE;
        return BLANK;
    }
}
