package Lesson10;



public class Dependency {
	private String groupId;
	
	private String artifactId;
	private String scope;
	
	public Dependency() {
	}
	private double version;
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public double getVersion() {
		return version;
	}
	public void setVersion(double version) {
		this.version = version;
	}
	
	
	
	public String getArtifactId() {
		return artifactId;
	}
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	@Override
	public String toString() {
		return  groupId + "," + artifactId + ",=" + scope + ","
				+ version;
	}
}
