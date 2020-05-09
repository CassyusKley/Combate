package etiocook.combate.listener;

import etiocook.combate.Main;
import etiocook.combate.manager.CombateManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class Hit implements Listener {

    public Main pl;

    public Hit(Main main) {
        this.pl = main;
        pl.getServer().getPluginManager().registerEvents(this, pl);
    }


    @EventHandler (ignoreCancelled = true)
    public void hit(EntityDamageByEntityEvent e) {

        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player player = (Player) e.getDamager();
            Player target = (Player) e.getEntity();
            CombateManager manager = Main.getInstance().getManager();

            if (manager.contains(target.getName()) && manager.contains(player.getName())) {

                manager.add(player.getName(), 15);
                manager.add(target.getName(), 15);

                return;

            }

            manager.add(target.getName(), 15);
            manager.add(player.getName(), 15);

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
