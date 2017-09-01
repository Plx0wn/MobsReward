package fr.plx0wn.Rewards;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import fr.plx0wn.MobsReward;
import fr.plx0wn.Utils;

public class Neutrals implements Listener {

	public static FileConfiguration config = MobsReward.instance.getConfig();
	public static FileConfiguration msgconf = MobsReward.msgconf;

	@SuppressWarnings("deprecation")
	public static void ifTypeIs(EntityType killed, String type, String name, Player player, double reward) {
		try {
			if (killed.equals(EntityType.fromName(type))) {
				if (config.getBoolean("enabled." + name)) {
					if (player.hasPermission("rewards.neutrals." + name)
							|| player.hasPermission("rewards.neutrals.*")) {
						if (reward < 0) {
							MobsReward.economy.withdrawPlayer(player.getName(), -reward).transactionSuccess();
							player.sendMessage(Utils.ColoredString(msgconf.getString("neutrals.loose." + name))
									.replace("<reward>", "" + reward));
						} else {
							MobsReward.economy.depositPlayer(player.getName(), reward).transactionSuccess();
							player.sendMessage(Utils.ColoredString(msgconf.getString("neutrals.earn." + name))
									.replace("<reward>", "" + reward));
						}
					}
				}
			}
		} catch (Exception e) {
		}
	}

	@EventHandler
	public void onEntityKill(EntityDeathEvent e) {

		double bat = config.getDouble("neutrals.bat");
		double chicken = config.getDouble("neutrals.chicken");
		double cow = config.getDouble("neutrals.cow");
		double donkey = config.getDouble("neutrals.donkey");
		double horse = config.getDouble("neutrals.horse");
		double ironGolem = config.getDouble("neutrals.iron_golem");
		double llama = config.getDouble("neutrals.llama");
		double mule = config.getDouble("neutrals.mule");
		double ocelot = config.getDouble("neutrals.ocelot");
		double parrot = config.getDouble("neutrals.parrot");
		double pig = config.getDouble("neutrals.pig");
		double polarBear = config.getDouble("neutrals.polar_bear");
		double rabbit = config.getDouble("neutrals.rabbit");
		double sheep = config.getDouble("neutrals.sheep");
		double snowman = config.getDouble("neutrals.snowman");
		double squid = config.getDouble("neutrals.squid");
		double villager = config.getDouble("neutrals.villager");
		double wolf = config.getDouble("neutrals.wolf");

		if (e.getEntity().getKiller() instanceof Player) {
			Player player = e.getEntity().getKiller();
			EntityType type = e.getEntityType();
			ifTypeIs(type, "BAT", "blaze", player, bat);
			ifTypeIs(type, "CHICKEN", "chicken", player, chicken);
			ifTypeIs(type, "COW", "cow", player, cow);
			ifTypeIs(type, "DONKEY", "donkey", player, donkey);
			ifTypeIs(type, "HORSE", "horse", player, horse);
			ifTypeIs(type, "IRON_GOLEM", "iron_golem", player, ironGolem);
			ifTypeIs(type, "LLAMA", "llama", player, llama);
			ifTypeIs(type, "MULE", "mule", player, mule);
			ifTypeIs(type, "OCELOT", "ocelot", player, ocelot);
			ifTypeIs(type, "PARROT", "parrot", player, parrot);
			ifTypeIs(type, "PIG", "pig", player, pig);
			ifTypeIs(type, "POLAR_BEAR", "polar_bear", player, polarBear);
			ifTypeIs(type, "RABBIT", "rabbit", player, rabbit);
			ifTypeIs(type, "SHEEP", "sheep", player, sheep);
			ifTypeIs(type, "SNOWMAN", "snowman", player, snowman);
			ifTypeIs(type, "SQUID", "squid", player, squid);
			ifTypeIs(type, "VILLAGER", "villager", player, villager);
			ifTypeIs(type, "WOLF", "villager", player, wolf);
		}
	}

}
