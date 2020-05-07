package etiocook.combate;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.TimeUnit;

public class CombateTimer extends BukkitRunnable {

    private Main main;

    @Override
    public void run() {

        for(Player player: Bukkit.getOnlinePlayers()) {

            if (main.getManager().contains(player.getName())) {

                if (main.getManager().get(player.getName()).getDelay() >= System.currentTimeMillis()) {

                    long t = main.getManager().get(player.getName()).getDelay() - System.currentTimeMillis();
                    main.sendBar(
                            player,
                            " §c" +TimeUnit.MILLISECONDS.toSeconds(t) + "segundos"
                    );

                } else {

                    main.getManager().remove(player.getName());
                    player.sendMessage("§aVoce nao está mais em pvp");

                }
            }

        }

    }
}
