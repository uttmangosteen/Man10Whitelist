package io.github.uttmangosteen.man10whitelist;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Man10Whitelist extends JavaPlugin {
    JavaPlugin plugin;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        boolean onoff = Bukkit.hasWhitelist();
        Bukkit.setWhitelist(true);
        Bukkit.getLogger().info("[Man10whitelist]ホワイトリストをONにしました");
        if (!onoff) {
            this.plugin = this;
            int waitSeconds = plugin.getConfig().getInt("waitSeconds", 60);
            if (waitSeconds < 0) return;
            Bukkit.getLogger().info("[Man10whitelist]ホワイトリストを" + waitSeconds + "秒後にOFFにします");
            Bukkit.getScheduler().runTaskLater(this, () -> {
                Bukkit.setWhitelist(false);
                Bukkit.getLogger().info("[Man10whitelist]ホワイトリストをOFFにしました");
            }, waitSeconds * 20L);
        }
    }

    @Override
    public void onDisable() {
    }
}
