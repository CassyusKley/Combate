package etiocook.combate.listener;

import etiocook.combate.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Interact implements Listener {

    private final Main main;

    public Interact(Main pl) {
        this.main = pl;
        pl.getServer().getPluginManager().registerEvents(this, pl);
    }

    @EventHandler
    public void interact(PlayerInteractEvent e) {

        Player player = e.getPlayer();
        ItemStack hand = player.getItemInHand();

        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

            if (hand.getType() == Material.ENDER_PEARL) {

                if (main.getManager().contains(player.getName())) {

                    player.sendMessage("§4§lCombate: §eVocê nao pode usar este item enquanto está em combate");
                    e.setCancelled(true);

                }
            }
        }
    }
}