package etiocook.combate.listener;

import etiocook.combate.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Hit implements Listener {

    public Main pl;

    public Hit(Main main) {
        this.pl = main;
        pl.getServer().getPluginManager().registerEvents(this, pl);
    }

    @EventHandler
    public void hit(EntityDamageByEntityEvent e) {

        if (e.getEntity() instanceof Player) {

            Player player = (Player)e.getEntity();

            if (e.getDamager() instanceof Player) {

                Player target = (Player) e.getDamager();

                if (Main.getInstance().getManager().contains(target.getName())
                        && Main.getInstance().getManager().contains(player.getName())) {

                    Main.getInstance().getManager().remove(target.getName());
                    Main.getInstance().getManager().remove(player.getName());
                    Main.getInstance().getManager().add(player.getName(), 60);
                    Main.getInstance().getManager().add(target.getName(), 60);

                    return;

                }

                Main.getInstance().getManager().add(target.getName(), 60);
                Main.getInstance().getManager().add(player.getName(), 60);
            }

        }
    }
}
