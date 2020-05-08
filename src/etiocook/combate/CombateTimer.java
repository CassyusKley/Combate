package etiocook.combate;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.TimeUnit;

public class CombateTimer extends BukkitRunnable {


    @Override
    public void run() {

        for(Player player: Bukkit.getOnlinePlayers()) {

            if (Main.getInstance().getManager().contains(player.getName())) {

                if (Main.getInstance().getManager().get(player.getName()).getDelay() >= System.currentTimeMillis()) {

                    long t = Main.getInstance().getManager().get(player.getName()).getDelay() - System.currentTimeMillis();
                    sendBar(
                            player,
                            "§4§lCombate: §fvocê esta em combate duração §c" +
                                    TimeUnit.MILLISECONDS.toSeconds(t) + " segundos"
                    );


                } else {

                    Main.getInstance().getManager().remove(player.getName());
                    player.sendMessage("§4§lCombate: §avocê nao está mais em combate");

                }
            }

        }

    }
    public void sendBar(Player player, String message) {
        IChatBaseComponent cbComponent = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(cbComponent, (byte) 2);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packetPlayOutChat);
    }
}
