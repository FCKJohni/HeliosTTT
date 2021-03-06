package eu.sentinal.heliosttt.inventories.pojo;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

@SuppressWarnings("all")
public enum Letter {

    A("MWE3NGQ5MjEyZTY0OTFiYzM3MGNhZjAyNWZkNDU5ZmU2MzJjYTdjNmJhNGRmN2ViZWZhZmQ0ODlhYjMyZmQifX19"),
    LIME_A(
            "Nzg5ZjA3M2UwZjg3ZDUwODM5NjM1NmY4YWY4ZGM3NjJjNTMxZTY2ODZiYmJlZGVhNTk4OTI3MjExZjljYmI1In19fQ=="),
    B("YTAxNzgzZjM3YzdiNWY2OTFjNjE1MTMwYWI4NWUxZTFhZDI1ZGZmY2VhZmQ3YmIxNzhiOTIxNzNkZjJhYWEifX19"),
    C("ODliNjZkYmYwMWM5NGFlZjdkY2ExYWJlODUzNmM5ZTUxMjk2OWZhMzJmNTcwNzU0Mjk3OWNhZjcyNThhZGM1In19fQ=="),
    D("MTg2NmI0NjJiNzc2Mzc0MzI4ZDhkYWYyY2U5ZTVhYmMzZWNjNjQ0ODFkNTRhNjljZDRjMmIyNWU3NjMwYzZhZiJ9fX0="),
    E("NTIyM2FmZTg5NWQzZDRlMzJmMzkzZGQzMDE5ODlhMzE3NTg1ZDllYmUzZjVkNzZkNDM4MGY1YTA2Zjk1In19fQ=="),
    LIME_E(
            "ZTc3NmZmYjNlODE5MThjM2E1NTI0MzRiZDE1YTI5Y2Y5NzE1Nzk0ZTc3OWYwNzQ0MTQ2ZmMxMmQyMzEzNDdkIn19fQ=="),
    F("ZmNlYjJhNDQ0MWI3M2Q0ZTc0NGFlZWNiYTlmZTZhZmIxODQ3MGI5OWEyNjJiZDFiYTFiY2M2OTEzYTJiYWFmIn19fQ=="),
    G("YmQ2MmQ2M2NmYjRiODczMWZjZDI2MzVkY2Y2OTIwM2RmMzkzOTQ2ZTFhZWNhMjYwNWFiOTYzZTI4MjlkYWIifX19"),
    H("OGY1Yjg3MWFlNDdlYmExNDZiNWI0Y2Y4OWZjMjBkYzMyMzY5NTJhN2VhODY3ODk4YmVjMWYzYjcxOTcxMmEifX19"),
    I("ZTdhMmY4YmY3ZTEzOGQ2YmE5MjQ2ZjdkYzFmZjE0NGY0M2VkNTEyZTQ0ODkyYjFlMzE2NTM1ZWE4ODJmN2E1In19fQ=="),
    J("MWRmOGI0ODJlZTc2OTc5ZmRiOTQ2N2M4ZTY2NmNjNmFlYzVjYjQ0ODU5YmI3NDU3OWYwMTYyOTFlZDAxMTc1In19fQ=="),
    K("NTE5OGZjZTdlYWZkYWNhMTViZDZlOThjYTk0YjQwNDY1ODNhOGIyZTU0MTFjYzhjOTQ0NTg4ZmQ3ZjFhNWY5NyJ9fX0="),
    L("OWY3ODQ2NmE3YjVhYWU5MDg4NGM2ZTIyMjdkNTI0OTc4MTM2MzU0NDU3MzgyZDM2NDdiMDdkMDk2YzJhMjJlIn19fQ=="),
    M("ZjJmMmQ4Mjc0OTUwNTM1NTdjNTJlNTVjY2RkNTcxYmQzMzE4NGZjMTQ5Mjg0NDFmM2E5N2VhYjM4OTIyODEyYyJ9fX0="),
    N("NjUxYTdlZTY2ZjYwMjM3NDE5OTE3ZmRjNzVmNWQzNDFjZmJiOWY3Y2NhYWVmM2FmZjJhZjQxOWQ1ODhlNzAxYSJ9fX0="),
    O("ZDk3YWE4YjlmN2VkOGMzOGFlNDFmMWJkNmQ5ZTEwZWI1N2JjODdlMThjYWMyNDdlN2JkMmE0ZTBlNTg4NTc4YSJ9fX0="),
    P("NzI3NDcxMzlmMzM4YTQ2YTQ1OTAzYjc2MzNmMjcwNTAyZDY0ZjA2NjUxNWY0ZDJmOWRlZjgwY2ZmOTExNTBmZiJ9fX0="),
    Q("ZTBmY2ZjNzQyY2ViOTQ2NGVmYzk3MWEzMWM1ODk2ZDk3MWU0NzcyNzcyNzQ1NzU2MjI1YjA2NDNlNGU5MyJ9fX0="),
    R("ZDgyZTZmMGY5ZWFlZjU2ZjM4M2E0YzVhMzkyYjE5NGJmMWExYjYzNTU5YWMzNjI1NWNjZWYyNDYzYzM4YyJ9fX0="),
    S("YmNlZjMzM2FhYmEyNDJjNmYyOGY0OWU5NjY4OWFiNGJmMmJjMTI2YmJjMjk4NTU1YjkzZGE3OTMyODQxOWQ4In19fQ=="),
    T("ZTViZjRkYjUxZmFiNGFhMjc5NjI4ZGZiMmExNzIwZTAxYmY3ZTliOTRiYjhjN2U3MDJmYjYzNzU3NDA1ZCJ9fX0="),
    U("M2FkZTQ2NjFlOTk4YWViMjAxMzYzOTZkOTQxMzZjMjdkNDk5MDIyODBhYjdlZWNmYTg4N2RiNDhhOWI2Y2YifX19"),
    V("OWRmNTNhMThjNTk2ODNmZDYzZjY4MjJjZDQ0NjRkMTJjODYyZDc4MThjNjhiMjMwMjg1N2I3MTlmNTVlNGZlOSJ9fX0="),
    W("MzU3YjFmNmViN2NmMGZkMjA0OTlhNWJlNmI4MmIyNWNmNWNiZDhlNTdkYWFjNzM1MWM4NWM0NWZiNWZlNWMifX19"),
    X("YmNjNWZhZTNiNjUwZTZlZGIzMjQ1ZmE0MWU1YmUyZGE3OWIwZTE3ZjIyYzRiNGUxZTU5YjMyZjU3MzIwMmQxOCJ9fX0="),
    Y("MzY3NDc3ZjljYjVmMDM2NDM4Y2U5OGNlNjk3YjkxMzU4Y2I5NzY0MWM1ZDE1M2E3ZTM4ODhkYWUzMmUyMTUifX19="),
    Z("Y2ZhNzMwYjVlYzczY2VhZjRhYWQ1MjRlMjA3ZmYzMWRmNzg1ZTdhYjZkYjFhZWIzZjFhYTRkMjQ1ZWQyZSJ9fX0="),
    COLON(
            "YTkxOWZlNTk5Zjk4MjU4ZGRmZjQ0Yzc2ODEzN2UyZTljYmFmNGI5NGY1YTI1MjMzYzI3ZjNkZDJmNTM1OSJ9fX0="),
    BLANK(
            "NmU1Mjg2YzQ3MGY2NmZmYTFhMTgzMzFjYmZmYjlhM2MyYTQ0MjRhOGM3MjU5YzQ0MzZmZDJlMzU1ODJhNTIyIn19fQ=="),
    PLUS(
            "MzIzMzJiNzcwYTQ4NzQ2OTg4NjI4NTVkYTViM2ZlNDdmMTlhYjI5MWRmNzY2YjYwODNiNWY5YTBjM2M2ODQ3ZSJ9fX0="),
    OAK_0(
            "MGViZTdlNTIxNTE2OWE2OTlhY2M2Y2VmYTdiNzNmZGIxMDhkYjg3YmI2ZGFlMjg0OWZiZTI0NzE0YjI3In19fQ=="),
    OAK_1(
            "NzFiYzJiY2ZiMmJkMzc1OWU2YjFlODZmYzdhNzk1ODVlMTEyN2RkMzU3ZmMyMDI4OTNmOWRlMjQxYmM5ZTUzMCJ9fX0="),
    OAK_2(
            "NGNkOWVlZWU4ODM0Njg4ODFkODM4NDhhNDZiZjMwMTI0ODVjMjNmNzU3NTNiOGZiZTg0ODczNDE0MTk4NDcifX19"),
    OAK_3(
            "MWQ0ZWFlMTM5MzM4NjBhNmRmNWU4ZTk1NTY5M2I5NWE4YzNiMTVjMzZiOGI1ODc1MzJhYzA5OTZiYzM3ZTUifX19"),
    OAK_4(
            "ZDJlNzhmYjIyNDI0MjMyZGMyN2I4MWZiY2I0N2ZkMjRjMWFjZjc2MDk4NzUzZjJkOWMyODU5ODI4N2RiNSJ9fX0="),
    OAK_5(
            "NmQ1N2UzYmM4OGE2NTczMGUzMWExNGUzZjQxZTAzOGE1ZWNmMDg5MWE2YzI0MzY0M2I4ZTU0NzZhZTIifX19"),
    OAK_6(
            "MzM0YjM2ZGU3ZDY3OWI4YmJjNzI1NDk5YWRhZWYyNGRjNTE4ZjVhZTIzZTcxNjk4MWUxZGNjNmIyNzIwYWIifX19"),
    OAK_7(
            "NmRiNmViMjVkMWZhYWJlMzBjZjQ0NGRjNjMzYjU4MzI0NzVlMzgwOTZiN2UyNDAyYTNlYzQ3NmRkN2I5In19fQ=="),
    OAK_8(
            "NTkxOTQ5NzNhM2YxN2JkYTk5NzhlZDYyNzMzODM5OTcyMjI3NzRiNDU0Mzg2YzgzMTljMDRmMWY0Zjc0YzJiNSJ9fX0="),
    OAK_9(
            "ZTY3Y2FmNzU5MWIzOGUxMjVhODAxN2Q1OGNmYzY0MzNiZmFmODRjZDQ5OWQ3OTRmNDFkMTBiZmYyZTViODQwIn19fQ=="),
    BLACK_0(
            "NmQ2ODM0M2JkMGIxMjlkZTkzY2M4ZDNiYmEzYjk3YTJmYWE3YWRlMzhkOGE2ZTJiODY0Y2Q4NjhjZmFiIn19fQ=="),
    BLACK_1(
            "ZDJhNmYwZTg0ZGFlZmM4YjIxYWE5OTQxNWIxNmVkNWZkYWE2ZDhkYzBjM2NkNTkxZjQ5Y2E4MzJiNTc1In19fQ=="),
    BLACK_2(
            "OTZmYWI5OTFkMDgzOTkzY2I4M2U0YmNmNDRhMGI2Y2VmYWM2NDdkNDE4OWVlOWNiODIzZTljYzE1NzFlMzgifX19"),
    BLACK_3(
            "Y2QzMTliOTM0M2YxN2EzNTYzNmJjYmMyNmI4MTk2MjVhOTMzM2RlMzczNjExMWYyZTkzMjgyN2M4ZTc0OSJ9fX0="),
    BLACK_4(
            "ZDE5OGQ1NjIxNjE1NjExNDI2NTk3M2MyNThmNTdmYzc5ZDI0NmJiNjVlM2M3N2JiZTgzMTJlZTM1ZGI2In19fQ=="),
    BLACK_5(
            "N2ZiOTFiYjk3NzQ5ZDZhNmVlZDQ0NDlkMjNhZWEyODRkYzRkZTZjMzgxOGVlYTVjN2UxNDlkZGRhNmY3YzkifX19"),
    BLACK_6(
            "OWM2MTNmODBhNTU0OTE4YzdhYjJjZDRhMjc4NzUyZjE1MTQxMmE0NGE3M2Q3YTI4NmQ2MWQ0NWJlNGVhYWUxIn19fQ=="),
    BLACK_7(
            "OWUxOThmZDgzMWNiNjFmMzkyN2YyMWNmOGE3NDYzYWY1ZWEzYzdlNDNiZDNlOGVjN2QyOTQ4NjMxY2NlODc5In19fQ=="),
    BLACK_8(
            "ODRhZDEyYzJmMjFhMTk3MmYzZDJmMzgxZWQwNWE2Y2MwODg0ODlmY2ZkZjY4YTcxM2IzODc0ODJmZTkxZTIifX19"),
    BLACK_9(
            "OWY3YWEwZDk3OTgzY2Q2N2RmYjY3YjdkOWQ5YzY0MWJjOWFhMzRkOTY2MzJmMzcyZDI2ZmVlMTlmNzFmOGI3In19fQ=="),
    BLACK_BLANK(
            "OWQ0ZjE4N2Y0MWNhZTY0MTU1OGY4Nzg3YmYxZTdiZTcyYTZkNzI5MTFiMjFjOTdkOTE2ZjBhN2ZhYWYyOGY3In19fQ=="),
    BLACK_ARROW_RIGHT(
            "NjgyYWQxYjljYjRkZDIxMjU5YzBkNzVhYTMxNWZmMzg5YzNjZWY3NTJiZTM5NDkzMzgxNjRiYWM4NGE5NmUifX19"),
    BLACK_ARROW_LEFT(
            "MzdhZWU5YTc1YmYwZGY3ODk3MTgzMDE1Y2NhMGIyYTdkNzU1YzYzMzg4ZmYwMTc1MmQ1ZjQ0MTlmYzY0NSJ9fX0="),
    RED_ARROW_RIGHT(
            "ZmNmZTg4NDVhOGQ1ZTYzNWZiODc3MjhjY2M5Mzg5NWQ0MmI0ZmMyZTZhNTNmMWJhNzhjODQ1MjI1ODIyIn19fQ=="),
    RED_BLANK(
            "M2NjNDcwYWUyNjMxZWZkZmFmOTY3YjM2OTQxM2JjMjQ1MWNkN2EzOTQ2NWRhNzgzNmE2YzdhMTRlODc3In19fQ=="),
    KEYPAD_GRAY(
            "YjAxYTU2OGViYTdlNDUzYjU1ZjE1NTQ1ZjVlMzVmZmFiODc5MWFhY2Y5MDM0YWZiYmJlNGJkZGIyMWZhNTAifX19"),
    RED_ARROW_LEFT(
            "Zjg0ZjU5NzEzMWJiZTI1ZGMwNThhZjg4OGNiMjk4MzFmNzk1OTliYzY3Yzk1YzgwMjkyNWNlNGFmYmEzMzJmYyJ9fX0="),
    LIME_CHECK(
            "YTkyZTMxZmZiNTljOTBhYjA4ZmM5ZGMxZmUyNjgwMjAzNWEzYTQ3YzQyZmVlNjM0MjNiY2RiNDI2MmVjYjliNiJ9fX0="),
    Stone_Arrow_Right(
            "ZjMyY2E2NjA1NmI3Mjg2M2U5OGY3ZjMyYmQ3ZDk0YzdhMGQ3OTZhZjY5MWM5YWMzYTkxMzYzMzEzNTIyODhmOSJ9fX0="),
    Stone_Arrow_Left(
            "ODY5NzFkZDg4MWRiYWY0ZmQ2YmNhYTkzNjE0NDkzYzYxMmY4Njk2NDFlZDU5ZDFjOTM2M2EzNjY2YTVmYTYifX19"),
    POLICE_OFFICER(
            "NjcxNTdjZmZiMDYwNjNiMzUyZGM2ODQ3OGY0NzZlN2QyMDJjM2JhNmU3Y2JmMjk3MjQxYmU4MTY4MTA3NGJmIn19fQ=="),
    FIREFIGHTER(
            "NzNkYzM5ZGZmZjE0YTQ5NTQ1ZmNjZjE1YTFjMDMyMTllZTRhZjJlNzI5NzJlMTNlZTJkZDA2NzlmNDhkNCJ9fX0="),
    NURSE(
            "NzkyNjk3N2Q0OTVlZjA5MjQ0NGFmYmRkMzYxMjY3Njc5MmU5Zjk1YWZlZGNmMmVkZmMzMjNhM2M2MmFhMjYifX19"),
    JUDGE(
            "MmQ5ZjFkZTliN2ZkOTg3NzhkNjFhNTg2NjlmZjdjNWU4NWRmZjZhYTY1MDhjZDRlZjk1OWUxZGU5ODc1OGMyIn19fQ=="),
    GRU("NGU3MDhjYjc3YjIyNTRlNzk3ZjJiODcxNmI0YjFiZjU4YzJjYjM3YmQzODI2ZGNiMThiZjU0ZGM5Njk5MzYifX19"),
    Scientist_NPC(
            "MjZkMDQ4YjY5YzZjNWMxN2ZhYjY1Yzc0YjBlYzA2NGU5NGZmODI4ZjFkODhlNzQ1MGMwZGJhOTlkZWY5MzM4YyJ9fX0="),
    NPC("OTFhYWU5YWE0NDhjMGE1YjY1MDhiZGUyMjk2NWU5MDA5MTlkZjdkZDU2MTNjNThhMTBkOWNmYjY3OTYyMjkzOSJ9fX0="),
    TAXI(
            "NzYxNjlmMzMwZTRhOGZlYTViNGJkNDkxZjg3YzUyNTY2NDNjN2Q1ZTNiNWMyYzM5MmRmY2VjNGZmZGIwMWQzYyJ9fX0="),
    Technical_Device(
            "MzU2YmJjMDc3ZWRlNmIyNzdiZmIyMTE1NDU1MmJhYzU3MWY1ODFjMTdlNzExMzY1NTVhMjM0ZWY4MjY3NjMxYSJ9fX0="),
    RED_A("NTFkMzgzNDAxZjc3YmVmZmNiOTk4YzJjZjc5YjdhZmVlMjNmMThjNDFkOGE1NmFmZmVkNzliYjU2ZTIyNjdhMyJ9fX0="),
    RED_P("NTY1ZjIzZGRjNmU4M2FiN2QwYzRhYTljNTc0NGFmN2I5NmJjNzM5YmM4M2E5NmNiMWYyYjE4ZDY3MWYifX19"),
    LIME_P("Yzc1YTVkYzMxMDg3ZjNhMTZmMjdhNGZmY2YyNTQyZWU4ZDUyMmYyNWViMTlkMDg5NWVmYzMyY2I5YzI1NDgifX19"),
    RED_T(
            "YTJjM2IyZTYyMjcxMmIxNDk1ZmI5NWRmY2IwNWViMTQzYjJmMjY5N2U2ZjNjNGU0YTNkNjg1Y2YzMWQ0In19fQ=="),
    RED_X(
            "YmViNTg4YjIxYTZmOThhZDFmZjRlMDg1YzU1MmRjYjA1MGVmYzljYWI0MjdmNDYwNDhmMThmYzgwMzQ3NWY3In19fQ=="),
    LIME_PLUS("YjA1NmJjMTI0NGZjZmY5OTM0NGYxMmFiYTQyYWMyM2ZlZTZlZjZlMzM1MWQyN2QyNzNjMTU3MjUzMWYifX19"),
    INFO_I("MTY0MzlkMmUzMDZiMjI1NTE2YWE5YTZkMDA3YTdlNzVlZGQyZDUwMTVkMTEzYjQyZjQ0YmU2MmE1MTdlNTc0ZiJ9fX0="),
    GRAY_FORWARD("ZTAyZmEzYjJkY2IxMWM2NjM5Y2M5YjkxNDZiZWE1NGZiYzY2NDZkODU1YmRkZTFkYzY0MzUxMjRhMTEyMTVkIn19fQ==");

    private String texture;

    private ItemStack itemStack;

    Letter(String texture) {
        this.texture = texture;

        ItemStack itemStack = new ItemUtils(Material.PLAYER_HEAD).setAmount(1).setSubId((short) 3)
                .build();
        if (itemStack.getItemMeta() instanceof SkullMeta) {
            SkullMeta meta = ((SkullMeta) itemStack.getItemMeta());
            PlayerProfile playerProfile = Bukkit.createProfile(UUID.randomUUID(), null);
            playerProfile.setProperty(new ProfileProperty("textures", getTexture()));
            meta.setPlayerProfile(playerProfile);
            meta.setDisplayName(ChatColor.GOLD + "??4");
            itemStack.setItemMeta(meta);
            this.itemStack = itemStack;
        }
    }

    public String getTexture() {
        return "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv" + texture;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

}
