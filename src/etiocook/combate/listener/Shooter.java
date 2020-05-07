package etiocook.combate.listener;

import etiocook.combate.Main;
import etiocook.combate.manager.CombateManager;
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

            if (a.getShooter() instanceof Player && e.getEntity() instanceof Player) {

                Player player = (Player) a.getShooter();
                Player target = (Player) e.getEntity();
                CombateManager manager = Main.getInstance().getManager();

                if (manager.contains(target.getName()) && manager.contains(player.getName())) {

                    manager.add(player.getName(), 60);
                    manager.add(target.getName(), 60);

                    return;

                }

                manager.add(target.getName(), 60);
                manager.add(player.getName(), 60);

                player.sendMessage(
                        "§4§lCombate: §7Você entrou em combate com §f§n"
                                + target.getName()
                                + "§r §7não deslogue");

                target.sendMessage(
                        "§4§lCombate: §7Você entrou em combate com §f§n"
                                + player.getName()
                                + "§r §7não deslogue");


            }
        }
    }
}