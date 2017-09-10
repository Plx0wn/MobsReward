package fr.plx0wn.Rewards;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import fr.plx0wn.MobsReward;
import fr.plx0wn.Utils;

public class Players implements Listener {

	public static FileConfiguration config = MobsReward.instance.getConfig();
	public static FileConfiguration msgconf = MobsReward.msgconf;

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityKill(EntityDeathEvent e) {

		if (e.getEntity().getKiller() instanceof Player) {
			Player killed = (Player) e.getEntity();
			Player killer = e.getEntity().getKiller();
			EntityType type = e.getEntityType();
			
			double playersDeath = config.getDouble("players.death");
			double playersKill = config.getDouble("players.kill");
			double all = MobsReward.economy.getBalance(killed);

			if (type.equals(EntityType.PLAYER)) {
				if (config.getBoolean("enabled.player-death")) {
					if (killed.hasPermission("rewards.players.death") || killed.hasPermission("rewards.players.*")) {
						if(config.get("player.death") instanceof String){
							if(config.getString("player.death").equalsIgnoreCase("all")){
								MobsReward.economy.withdrawPlayer(killed.getName(), all).transactionSuccess();
								killed.sendMessage(Utils.ColoredString(msgconf.getString("players.loss.death_all")));
							} else {
								Bukkit.getConsoleSender().sendMessage(Utils.ColoredString("&cWrong syntax in config.yml line 23. This line need to be a number or equal to 'all'"));
							}
						} else {
							if (playersDeath < 0) {
								MobsReward.economy.withdrawPlayer(killed.getName(), -playersDeath).transactionSuccess();
								killed.sendMessage(Utils.ColoredString(msgconf.getString("players.loss.death"))
										.replace("<reward>", "" + playersDeath));
							} else {
								MobsReward.economy.depositPlayer(killed.getName(), playersDeath).transactionSuccess();
								killed.sendMessage(Utils.ColoredString(msgconf.getString("players.earn.death"))
										.replace("<reward>", "" + playersDeath));
							}
						}
					}
				}
				if (config.getBoolean("enabled.player-kill")) {
					if (killer.hasPermission("rewards.players.kill") || killer.hasPermission("rewards.players.*")) {
						if (playersKill < 0) {
							MobsReward.economy.withdrawPlayer(killer.getName(), -playersKill).transactionSuccess();
							killer.sendMessage(Utils.ColoredString(msgconf.getString("players.loss.death"))
									.replace("<reward>", "" + playersKill));
						} else {
							MobsReward.economy.depositPlayer(killer.getName(), playersKill).transactionSuccess();
							killer.sendMessage(Utils.ColoredString(msgconf.getString("players.earn.death"))
									.replace("<reward>", "" + playersKill));
						}
					}
				}
			}
		}
	}

}
