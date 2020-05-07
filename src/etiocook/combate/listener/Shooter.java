package etiocook.combate.listener;

import etiocook.combate.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class Shooter implements Listener {
    public Main pl;

    public Shooter(Main pl) {
        this.pl = pl;
        pl.getServer().getPluginManager().registerEvents(this, pl);
    }

    @EventHandler
    public void shooter(EntityDamageByEntityEvent e) {

        if (e.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)) {
            Arrow a = (Arrow) e.getDamager();

            if (a.getShooter() instanceof Player) {
                Player player = (Player) a.getShooter();

                if (e.getEntity() instanceof Player) {
                    Player target = (Player) e.getEntity();

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
}