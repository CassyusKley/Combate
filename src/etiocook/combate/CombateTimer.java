package etiocook.combate;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class CombateTimer extends BukkitRunnable {

    @Override
    public void run() {

        for(Player player: Bukkit.getOnlinePlayers()) {

            if (Main.getInstance().getManager().contains(player.getName())) {

                if (Main.getInstance().getManager().get(player.getName()).getDelay() >= System.currentTimeMillis()) {

                    long t = Main.getInstance().getManager().get(player.getName()).getDelay() - System.currentTimeMillis();
                    Main.getInstance().sendBar(player, " §c" +TimeUnit.MILLISECONDS.toSeconds(t));

                } else {

                    Main.getInstance().getManager().remove(player.getName());
                    player.sendMessage("§aVoce nao está mais em pvp");

                }
            }

        }

    }
}
