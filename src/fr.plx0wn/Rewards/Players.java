package fr.plx0wn.Rewards;

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

		double playersDeath = config.getDouble("players.death");
		double playersKill = config.getDouble("players.kill");

		if (e.getEntity().getKiller() instanceof Player) {
			Player player = e.getEntity().getKiller();
			EntityType type = e.getEntityType();

			if (type.equals(EntityType.PLAYER)) {
				if (config.getBoolean("enabled.player-death")){
					MobsReward.economy.withdrawPlayer(player.getName(), playersDeath)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("players.death")).replace("<loss>", "" + playersDeath));
				}
				if (config.getBoolean("enabled.player-kill")){
					MobsReward.economy.depositPlayer(player.getName(), playersKill)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("players.kill")).replace("<reward>", "" + playersKill));
				}
			}
		}
	}

}
