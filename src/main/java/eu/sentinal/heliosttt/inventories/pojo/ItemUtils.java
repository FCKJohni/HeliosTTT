package eu.sentinal.heliosttt.inventories.pojo;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;

import java.util.List;

public class ItemUtils {

  private ItemStack itemStack;

  public ItemUtils(Material material) {
    this.itemStack = new ItemStack(material);
  }

  public ItemUtils(ItemStack itemStack) {
    this.itemStack = itemStack;
  }

  public ItemUtils setItemStack(ItemStack itemStack) {
    this.itemStack = itemStack;
    return this;
  }

  public ItemUtils addDisplayName(String display) {
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(display);
    itemStack.setItemMeta(itemMeta);
    return this;
  }

  public ItemUtils addEnchantUnsafe(Enchantment enchantment, int level) {
    itemStack.addUnsafeEnchantment(enchantment, level);
    return this;
  }

  public ItemUtils setLore(List<String> strings) {
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setLore(strings);
    itemStack.setItemMeta(itemMeta);
    return this;
  }

  public ItemUtils setCustomModel(int model) {
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(model);
    itemStack.setItemMeta(itemMeta);
    return this;
  }

  public ItemUtils setAmount(int integer) {
    this.itemStack.setAmount(integer);
    return this;
  }

  public ItemUtils setSubId(short id) {
    if (itemStack.getItemMeta() instanceof Damageable) {
      Damageable damageable = (Damageable) itemStack.getItemMeta();
      damageable.setDamage(id);
      return this;
    }
    return this;
  }

  public ItemUtils setPotion(PotionData potion) {
    if (itemStack.getItemMeta() instanceof PotionMeta) {
      PotionMeta meta = ((PotionMeta) itemStack.getItemMeta());
      meta.setBasePotionData(potion);
      itemStack.setItemMeta(meta);
    }
    return this;
  }

  public ItemUtils setPotion(PotionData potion, Color color) {
    if (itemStack.getItemMeta() instanceof PotionMeta) {
      PotionMeta meta = ((PotionMeta) itemStack.getItemMeta());
      meta.setBasePotionData(potion);
      meta.setColor(color);
      itemStack.setItemMeta(meta);
    }
    return this;
  }

  public ItemStack build() {
    return this.itemStack;
  }
}
