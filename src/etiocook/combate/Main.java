package etiocook.combate;

import etiocook.combate.listener.*;
import etiocook.combate.manager.CombateManager;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    private final CombateManager manager = CombateManager.getInstance();

    @Override
    public void onEnable() {
        instance = this;

        new Hit(this);
        new Leaving(this);
        new Interact(this);
        new Shooter(this);
        new CommandsBlock(this);
        new Death(this);

        new CombateTimer().runTaskTimerAsynchronously(this,0,20);

    }

    public static Main getInstance() {
        if(instance == null) instance = new Main();
        return instance;
    }

    public CombateManager getManager() {
        if(instance == null) instance = new Main();
        return manager;
    }

    public void sendBar(Player player, String message) {
        IChatBaseComponent cbComponent = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(cbComponent, (byte) 2);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packetPlayOutChat);
    }
}
