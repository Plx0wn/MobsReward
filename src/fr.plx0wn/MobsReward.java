package fr.plx0wn;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import fr.plx0wn.Rewards.Mobs;
import fr.plx0wn.Rewards.Players;
import net.milkbowl.vault.economy.Economy;

public class MobsReward extends JavaPlugin {

	public static Plugin instance;
	public static Economy economy = null;
	public static File msgfile, configfile;
	public static FileConfiguration msgconf;

	public void onEnable() {
		instance = this;
		
		setupEconomy();

		getConfig().options().copyDefaults();
		saveDefaultConfig();
		createFiles();

		Bukkit.getServer().getPluginManager().registerEvents(new Mobs(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Players(), this);
	}

	private void createFiles() {

		msgfile = new File(getDataFolder(), "messages.yml");
		configfile = new File(getDataFolder(), "config.yml");
		if (!msgfile.exists()) {
			msgfile.getParentFile().mkdirs();
			saveResource("messages.yml", false);
		}

		try {
			msgconf = new YamlConfiguration();
			msgconf.load(msgfile);
		} catch (InvalidConfigurationException | IOException e) {
			e.printStackTrace();
		}
	}

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		economy = rsp.getProvider();
		return economy != null;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("rewards")) {
			if (sender.hasPermission("rewards.admin")) {
				if (args.length == 0) {
					sender.sendMessage(Utils.ColoredString("&cTry /rewards reload"));
				}
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("reload")) {
						try {
							getConfig().load(configfile);
							sender.sendMessage(Utils.ColoredString("&aConfig.yml reloaded!"));
						} catch (Exception e) {
							e.printStackTrace();
							sender.sendMessage(Utils
									.ColoredString("&cConfig.yml can't be reloaded. Read logs for more informations."));
						}
						try {
							msgconf.load(msgfile);
							sender.sendMessage(Utils.ColoredString("&aMessages.yml reloaded!"));
						} catch (Exception e) {
							e.printStackTrace();
							sender.sendMessage(Utils
									.ColoredString("&aMessages.yml can't be reloaded. Read logs for more informations."));
						}
					} else {

					}
				}
			}
		}
		return false;
	}

}
