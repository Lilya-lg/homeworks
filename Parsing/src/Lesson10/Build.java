package Lesson10;

public class Build {
	private Plugin plugin;

	public Plugin getPlugin() {
		return plugin;
	}

	public void setPlugin(Plugin plugin) {
		this.plugin = plugin;
	}

	public Build() {
	}

	@Override
	public String toString() {
		return plugin.toString();
	}
	
}
