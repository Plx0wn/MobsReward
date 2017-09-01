package fr.plx0wn.Rewards;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import fr.plx0wn.MobsReward;
import fr.plx0wn.Utils;

public class Mobs implements Listener {

	public static FileConfiguration config = MobsReward.instance.getConfig();
	public static FileConfiguration msgconf = MobsReward.msgconf;

	@SuppressWarnings("deprecation")
	public static void ifTypeIs(EntityType killed, String type, String name, Player player, double reward) {
		try {
			if (killed.equals(EntityType.fromName(type))) {
				if (config.getBoolean("enabled." + name)) {
					if (player.hasPermission("rewards.mobs." + name) || player.hasPermission("rewards.mobs.*")) {
						if (reward < 0) {
							MobsReward.economy.withdrawPlayer(player.getName(), -reward).transactionSuccess();
							player.sendMessage(Utils.ColoredString(msgconf.getString("mobs.loose." + name))
									.replace("<reward>", "" + reward));
						} else {
							MobsReward.economy.depositPlayer(player.getName(), reward).transactionSuccess();
							player.sendMessage(Utils.ColoredString(msgconf.getString("mobs.earn." + name))
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

		double blaze = config.getDouble("mobs.blaze");
		double caveSpider = config.getDouble("mobs.cave_spider");
		double creeper = config.getDouble("mobs.creeper");
		double elderGuardian = config.getDouble("mobs.elder_guardian");
		double enderDragon = config.getDouble("mobs.ender_dragon");
		double enderman = config.getDouble("mobs.enderman");
		double endermite = config.getDouble("mobs.endermite");
		double evoker = config.getDouble("mobs.evoker");
		double ghast = config.getDouble("mobs.ghast");
		double giant = config.getDouble("mobs.giant");
		double guardian = config.getDouble("mobs.guardian");
		double husk = config.getDouble("mobs.husk");
		double illusioner = config.getDouble("mobs.illusioner");
		double magmaCube = config.getDouble("mobs.magma_cube");
		double pigZombie = config.getDouble("mobs.pig_zombie");
		double shulker = config.getDouble("mobs.shulker");
		double silverfish = config.getDouble("mobs.silverfish");
		double skeleton = config.getDouble("mobs.skeleton");
		double slime = config.getDouble("mobs.slime");
		double spider = config.getDouble("mobs.spider");
		double stray = config.getDouble("mobs.stray");
		double vex = config.getDouble("mobs.vex");
		double vindicator = config.getDouble("mobs.vindicator");
		double witch = config.getDouble("mobs.witch");
		double wither = config.getDouble("mobs.wither");
		double witherSkeleton = config.getDouble("mobs.wither_skeleton");
		double zombie = config.getDouble("mobs.zombie");
		double zombieVillager = config.getDouble("mobs.zombie_villager");

		if (e.getEntity().getKiller() instanceof Player) {
			Player player = e.getEntity().getKiller();
			EntityType type = e.getEntityType();
			ifTypeIs(type, "BLAZE", "blaze", player, blaze);
			ifTypeIs(type, "CAVE_SPIDER", "cave_spider", player, caveSpider);
			ifTypeIs(type, "CREEPER", "creeper", player, creeper);
			ifTypeIs(type, "ELDER_GUARDIAN", "elder_guardian", player, elderGuardian);
			ifTypeIs(type, "ENDER_DRAGON", "ender_dragon", player, enderDragon);
			ifTypeIs(type, "ENDERMAN", "enderman", player, enderman);
			ifTypeIs(type, "ENDERMITE", "endermite", player, endermite);
			ifTypeIs(type, "EVOKER", "evoker", player, evoker);
			ifTypeIs(type, "GHAST", "ghast", player, ghast);
			ifTypeIs(type, "GIANT", "giant", player, giant);
			ifTypeIs(type, "GUARDIAN", "guardian", player, guardian);
			ifTypeIs(type, "HUSK", "husk", player, husk);
			ifTypeIs(type, "ILLUSIONER", "illusioner", player, illusioner);
			ifTypeIs(type, "MAGMA_CUBE", "magma_cube", player, magmaCube);
			ifTypeIs(type, "PIG_ZOMBIE", "pig_zombie", player, pigZombie);
			ifTypeIs(type, "SHULKER", "shulker", player, shulker);
			ifTypeIs(type, "SILVERFISH", "silverfish", player, silverfish);
			ifTypeIs(type, "SKELETON", "skeleton", player, skeleton);
			ifTypeIs(type, "SLIME", "slime", player, slime);
			ifTypeIs(type, "SPIDER", "spider", player, spider);
			ifTypeIs(type, "STRAY", "stray", player, stray);
			ifTypeIs(type, "VEX", "vex", player, vex);
			ifTypeIs(type, "VINDICATOR", "vindicator", player, vindicator);
			ifTypeIs(type, "WITCH", "witch", player, witch);
			ifTypeIs(type, "WITHER", "wither", player, wither);
			ifTypeIs(type, "WITHER_SKELETON", "wither_skeleton", player, witherSkeleton);
			ifTypeIs(type, "ZOMBIE", "zombie", player, zombie);
			ifTypeIs(type, "ZOMBIE_VILLAGER", "zombie_villager", player, zombieVillager);
		}
	}

}
