package tech.nully.BossBarAPI;

import com.comphenix.protocol.ProtocolLibrary;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class BossBar {
    private Location dragonLocation;
    private int bossHealth = 200;
    private String text = "A BossBar!";

    private SpawnFakeWither.FakeWither dragon;

    private BukkitTask task;

    public BossBar(Player p) {
        this.dragonLocation = new Location(p.getWorld(), p.getLocation().getX(), -15, p.getLocation().getZ());
    }

    public Location getDragonLocation() {
        return dragonLocation;
    }

    public int getHealth() {
        return bossHealth;
    }

    public void setHealth(int bossHealth) {
        this.bossHealth = bossHealth;
        if (dragon != null) {
            dragon.setHealth(bossHealth);
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        if (dragon != null) {
            dragon.setCustomName(text);
        }
    }

    public void display() {
        if (dragon != null) {
            dragon.destroy();
        }
        dragon = new SpawnFakeWither.FakeWither(dragonLocation, ProtocolLibrary.getProtocolManager());
        dragon.setCustomName(text);
        dragon.setVisible(false);
        dragon.create();
    }

    public void delete() {
        if (dragon != null) {
            dragon.destroy();
        }
    }
}