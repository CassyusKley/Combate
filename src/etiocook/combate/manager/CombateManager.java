package etiocook.combate.manager;

import etiocook.combate.object.Combate;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CombateManager {

    private static CombateManager instance;

    private Map<String, Combate> manager = new HashMap<>();

    public Combate get(String name){

        return manager.get(name);
    }

    public void add(String name, long delay){

        Combate items = new Combate(
                name,
                System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(delay)
        );

            manager.put(name, items);

    }

    public void teste(){

        Bukkit.broadcastMessage("§e " + manager);
    }

    public void remove(String name){

        manager.remove(name);
    }

    public boolean contains(String name){

        return manager.containsKey(name);
    }


    public static CombateManager getInstance() {
        if(instance == null) instance = new CombateManager();
        return instance;
    }

    public static void setInstance(CombateManager instance) {
        CombateManager.instance = instance;
    }
}
