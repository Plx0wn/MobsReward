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
	@EventHandler
	public void onEntityKill(EntityDeathEvent e) {

		double blaze = config.getDouble("mobs.blaze");
		double caveSpider = config.getDouble("mobs.cave-spider");
		double creeper = config.getDouble("mobs.creeper");
		double enderDragon = config.getDouble("mobs.ender-dragon");
		double enderman = config.getDouble("mobs.enderman");
		double endermite = config.getDouble("mobs.endermite");
		double ghast = config.getDouble("mobs.ghast");
		double giant = config.getDouble("mobs.giant");
		double guardian = config.getDouble("mobs.guardian");
		double magmaCube = config.getDouble("mobs.magma-cube");
		double pigZombie = config.getDouble("mobs.pig-zombie");
		double silverfish = config.getDouble("mobs.silverfish");
		double skeleton = config.getDouble("mobs.skeleton");
		double slime = config.getDouble("mobs.slime");
		double spider = config.getDouble("mobs.spider");
		double witch = config.getDouble("mobs.witch");
		double wither = config.getDouble("mobs.wither");
		double witherSkeleton = config.getDouble("mobs.wither-skeleton");
		double zombie = config.getDouble("mobs.zombie");

		if (e.getEntity().getKiller() instanceof Player) {
			Player player = e.getEntity().getKiller();
			EntityType type = e.getEntityType();
			if (type.equals(EntityType.BLAZE)) {
				if (config.getBoolean("enabled.blaze")) {
					MobsReward.economy.depositPlayer(player.getName(), blaze).transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.blaze")).replace("<reward>", "" + blaze));
				}
			}
			if (type.equals(EntityType.CAVE_SPIDER)) {
				if (config.getBoolean("enabled.cave-spider")) {
					MobsReward.economy.depositPlayer(player.getName(), caveSpider).transactionSuccess();
					player.sendMessage(Utils.ColoredString(msgconf.getString("mobs.cave-spider")).replace("<reward>",
							"" + caveSpider));
				}
			}
			if (type.equals(EntityType.CREEPER)) {
				if (config.getBoolean("enabled.creeper")) {
					MobsReward.economy.depositPlayer(player.getName(), creeper).transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.creeper")).replace("<reward>", "" + creeper));
				}
			}
			if (type.equals(EntityType.ENDER_DRAGON)) {
				if (config.getBoolean("enabled.ender-dragon")){
					MobsReward.economy.depositPlayer(player.getName(), enderDragon)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.ender-dragon")).replace("<reward>", "" + enderDragon));
				}
			}
			if (type.equals(EntityType.ENDERMAN)) {
				if (config.getBoolean("enabled.enderman")){
					MobsReward.economy.depositPlayer(player.getName(), enderman)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.enderman")).replace("<reward>", "" + enderman));
				}
			}
			if (type.equals(EntityType.ENDERMITE)) {
				if (config.getBoolean("enabled.endermite")){
					MobsReward.economy.depositPlayer(player.getName(), endermite)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.endermite")).replace("<reward>", "" + endermite));
				}
			}
			if (type.equals(EntityType.GHAST)) {
				if (config.getBoolean("enabled.ghast")){
					MobsReward.economy.depositPlayer(player.getName(), ghast)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.ghast")).replace("<reward>", "" + ghast));
				}
			}
			if (type.equals(EntityType.GIANT)) {
				if (config.getBoolean("enabled.giant")){
					MobsReward.economy.depositPlayer(player.getName(), giant)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.giant")).replace("<reward>", "" + giant));
				}
			}
			if (type.equals(EntityType.GUARDIAN)) {
				if (config.getBoolean("enabled.guardian")){
					MobsReward.economy.depositPlayer(player.getName(), guardian)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.guardian")).replace("<reward>", "" + guardian));
				}
			}
			if (type.equals(EntityType.MAGMA_CUBE)) {
				if (config.getBoolean("enabled.magma-cube")){
					MobsReward.economy.depositPlayer(player.getName(), magmaCube)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.magma-cube")).replace("<reward>", "" + magmaCube));
				}
			}
			if (type.equals(EntityType.PIG_ZOMBIE)) {
				if (config.getBoolean("enabled.pig-zombie")){
					MobsReward.economy.depositPlayer(player.getName(), pigZombie)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.pig-zombie")).replace("<reward>", "" + pigZombie));
				}
			}
			if (type.equals(EntityType.SILVERFISH)) {
				if (config.getBoolean("enabled.silverfish")){
					MobsReward.economy.depositPlayer(player.getName(), silverfish)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.silverfish")).replace("<reward>", "" + silverfish));
				}
			}
			if (type.equals(EntityType.SKELETON)) {
				if (config.getBoolean("enabled.skeleton")){
					MobsReward.economy.depositPlayer(player.getName(), skeleton)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.skeleton")).replace("<reward>", "" + skeleton));
				}
			}
			if (type.equals(EntityType.SLIME)) {
				if (config.getBoolean("enabled.slime")){
					MobsReward.economy.depositPlayer(player.getName(), slime)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.slime")).replace("<reward>", "" + slime));
				}
			}
			if (type.equals(EntityType.SPIDER)) {
				if (config.getBoolean("enabled.spider")){
					MobsReward.economy.depositPlayer(player.getName(), spider)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.spider")).replace("<reward>", "" + spider));
				}
			}
			if (type.equals(EntityType.WITCH)) {
				if (config.getBoolean("enabled.witch")){
					MobsReward.economy.depositPlayer(player.getName(), witch)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.witch")).replace("<reward>", "" + witch));
				}
			}
			if (type.equals(EntityType.WITHER)) {
				if (config.getBoolean("enabled.wither")){
					MobsReward.economy.depositPlayer(player.getName(), wither)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.wither")).replace("<reward>", "" + wither));
				}
			}
			if (type.equals(EntityType.WITHER_SKELETON)) {
				if (config.getBoolean("enabled.wither-skeleton")){
					MobsReward.economy.depositPlayer(player.getName(), witherSkeleton)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.wither")).replace("<reward>", "" + witherSkeleton));
				}
			}
			if (type.equals(EntityType.ZOMBIE)) {
				if (config.getBoolean("enabled.zombie")){
					MobsReward.economy.depositPlayer(player.getName(), zombie)
							.transactionSuccess();
					player.sendMessage(
							Utils.ColoredString(msgconf.getString("mobs.zombie")).replace("<reward>", "" + zombie));
				}
			}
		}
	}

}
