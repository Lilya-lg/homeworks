package Lesson10;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String modelVersion;
	
	private String groupId;
	private String artifactId;
	private String version;
	private String name;
	private String url;
	private Property prop;
	//private Dependency[] deps;
	private List<Dependency> depList = new ArrayList<>();
	private Dependency dep;
	private Build build;
	
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public String getModelVersion() {
		return modelVersion;
	}
	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public void addDep(Dependency dep) {
		depList.add(dep);
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Property getProp() {
		return prop;
	}
	public void setProp(Property prop) {
		this.prop = prop;
	}
	public Dependency getDep() {
		return dep;
	}
	public void setDep(Dependency dep) {
		this.dep = dep;
	}
	public Build getBuild() {
		return build;
	}
	public void setBuild(Build build) {
		this.build = build;
	}
	@Override
	public String toString() {
		StringBuilder depString = new StringBuilder();
		for (Dependency dep:depList) {
			depString = depString.append(dep.toString());
		}
		System.out.println(depString);
		return  modelVersion + "," + groupId + "," + artifactId + "," + version + ", " + name + "," + url  + "," + depString;
	}
}
