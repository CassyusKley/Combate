package etiocook.combate.command;

import etiocook.combate.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class CombateCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) return true;

        Player player = (Player)sender;
        if(cmd.getName().equalsIgnoreCase("combate")) {
            if (!player.hasPermission("etio.combate")) return true;

            if (args.length == 0) {
                player.sendMessage(" §f/combate §7info [player] - verificar se um jogador ta em combate");

                return true;
            }
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("info")) {
                    Player target = Bukkit.getPlayer(args[1]);

                    if (Main.getInstance().getManager().contains(target.getName())) {
                        player.sendMessage("§eInformações do player §f" + target.getName() + " §e - ECombate");
                        player.sendMessage(" ");
                        player.sendMessage("§fCombate: §aAtivado");
                        player.sendMessage("§fVida: §7" + player.getHealth() + "/20.0");
                        player.sendMessage("§fSpeed: §7" + player.getFlySpeed());
                        player.sendMessage("§fFly: §7" + player.getAllowFlight());

                        for (PotionEffect effect : player.getActivePotionEffects()) {

                            player.sendMessage("§fPoções: §7" + effect.getType());

                            return true;
                        }
                        return true;
                    }

                    player.sendMessage("§eInformações do player §f" + target.getName() + " §e - ECombate");
                    player.sendMessage(" ");
                    player.sendMessage("§fCombate: §4Desativado");
                    player.sendMessage("§fVida: §7" + player.getHealth() + "/20.0");
                    player.sendMessage("§fSpeed: §7" + player.getFlySpeed());
                    player.sendMessage("§fFly: §7" + player.getAllowFlight());

                    for (PotionEffect effect : player.getActivePotionEffects()) {

                        player.sendMessage("§fPoções: §7" + effect.getType());
                    }
                }
            }
        }
        return false;
    }
}
