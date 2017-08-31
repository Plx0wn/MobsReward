package fr.plx0wn.Rewards;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import fr.plx0wn.MobsReward;
import fr.plx0wn.Utils;

public class Mobs implements Listener {

	public static FileConfiguration config = MobsReward.instance.getConfig();
	public static FileConfiguration msgconf = MobsReward.msgconf;

	@SuppressWarnings("deprecation")
	public static void ifTypeIs(EntityType killed, EntityType type, String name, Player player, double reward) {
		if (killed.equals(type)) {
			if (config.getBoolean("enabled." + name)) {
				if (reward < 0) {
					MobsReward.economy.withdrawPlayer(player.getName(), -reward).transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.loose." + name)).replace("<reward>", "" + reward));
				} else {
					MobsReward.economy.depositPlayer(player.getName(), reward).transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.earn." + name)).replace("<reward>", "" + reward));
				}
			}
		}
	}

	@EventHandler
	public void onEntityKill(EntityDeathEvent e) {

		double blaze = config.getDouble("mobs.blaze");
		double cave_spider = config.getDouble("mobs.cave_spider");
		double creeper = config.getDouble("mobs.creeper");
		double enderDragon = config.getDouble("mobs.ender_dragon");
		double enderman = config.getDouble("mobs.enderman");
		double endermite = config.getDouble("mobs.endermite");
		double ghast = config.getDouble("mobs.ghast");
		double giant = config.getDouble("mobs.giant");
		double guardian = config.getDouble("mobs.guardian");
		double magmaCube = config.getDouble("mobs.magma_cube");
		double pigZombie = config.getDouble("mobs.pig_zombie");
		double silverfish = config.getDouble("mobs.silverfish");
		double skeleton = config.getDouble("mobs.skeleton");
		double slime = config.getDouble("mobs.slime");
		double spider = config.getDouble("mobs.spider");
		double witch = config.getDouble("mobs.witch");
		double wither = config.getDouble("mobs.wither");
		double witherSkeleton = config.getDouble("mobs.wither_skeleton");
		double zombie = config.getDouble("mobs.zombie");

		if (e.getEntity().getKiller() instanceof Player) {
			Player player = e.getEntity().getKiller();
			EntityType type = e.getEntityType();
			ifTypeIs(type, EntityType.BLAZE, "blaze", player, blaze);
			ifTypeIs(type, EntityType.CAVE_SPIDER, "cave_spider", player, cave_spider);
			ifTypeIs(type, EntityType.CREEPER, "creeper", player, creeper);
			ifTypeIs(type, EntityType.ENDER_DRAGON, "ender_dragon", player, enderDragon);
			ifTypeIs(type, EntityType.ENDERMAN, "enderman", player, enderman);
			ifTypeIs(type, EntityType.ENDERMITE, "endermite", player, endermite);
			ifTypeIs(type, EntityType.GHAST, "ghast", player, ghast);
			ifTypeIs(type, EntityType.GIANT, "giant", player, giant);
			ifTypeIs(type, EntityType.GUARDIAN, "guardian", player, guardian);
			ifTypeIs(type, EntityType.MAGMA_CUBE, "magma_cube", player, magmaCube);
			ifTypeIs(type, EntityType.PIG_ZOMBIE, "pig_zombie", player, pigZombie);
			ifTypeIs(type, EntityType.SILVERFISH, "blaze", player, silverfish);
			ifTypeIs(type, EntityType.SKELETON, "skeleton", player, skeleton);
			ifTypeIs(type, EntityType.SLIME, "slime", player, slime);
			ifTypeIs(type, EntityType.SPIDER, "spider", player, spider);
			ifTypeIs(type, EntityType.WITCH, "witch", player, witch);
			ifTypeIs(type, EntityType.WITHER, "wither", player, wither);
			ifTypeIs(type, EntityType.WITHER_SKELETON, "wither_skeleton", player, witherSkeleton);
			ifTypeIs(type, EntityType.ZOMBIE, "zombie", player, zombie);
		}
	}

}
