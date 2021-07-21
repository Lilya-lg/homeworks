package Lesson10;

public class Plugin {
	private String artifactId;

	private String version;
	private Execution execution;
	private Configuration conf;
	public String getArtifactId() {
		return artifactId;
	}
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Execution getExecution() {
		return execution;
	}
	public void setExecution(Execution execution) {
		this.execution = execution;
	}
	public Configuration getConf() {
		return conf;
	}
	public void setConf(Configuration conf) {
		this.conf = conf;
	}
	public Plugin() {
	}
	@Override
	public String toString() {
		return artifactId + "," + version + "," + execution + ","
				+ conf;
	}
}
