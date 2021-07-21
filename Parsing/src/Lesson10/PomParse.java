package Lesson10;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PomParse extends DefaultHandler{
	private Project project;
	private Dependency dep;
	private Build build;
	private Plugin plugin;
	private Configuration conf;
	private DescriptorRef desc;
	private Manifest manifest;
	private Archive archive;
	private Execution exec;
	private Goal goal;
	private List<Project> projectList = new ArrayList<>();
	private List<Dependency> depList = new ArrayList<>();
	private String currentNode;
	private final String MODEL_VERSION   = "modelVersion";
	private final String GROUP_ID   = "groupId";
	private final String VERSION   = "version";
	private final String ARTIFACT_ID = "artifactId";
	private final String NAME = "name";
	private final String URL = "url";
	private final String SCOPE = "scope";
	private final String PROJECT = "project";
	private final String DEPENDENCY = "dependency";
	private final String BUILD = "build";
	private final String PLUGIN = "plugin";
	private final String CONFIGURATION = "configuration";
	private final String DESCRIPTORREF = "descriptorRef";
	private final String MANIFEST = "manifest";
	private final String MAIN_CLASS = "mainClass";
	private final String ARCHIVE = "archive";
	private final String EXECUTION = "execution";
	private final String ID = "id";
	private final String GOAL = "goal";
	private final String PHASE = "phase";
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start document found");
	}
	
   
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		//System.out.println(qName);
		currentNode = qName;
		switch(currentNode) {
		case PROJECT:
			project = new Project();
			break;
		case DEPENDENCY:
			dep = new Dependency();
			break;
		case BUILD:
			build = new Build();
			break;
		case PLUGIN:
			plugin = new Plugin();
			break;	
		case CONFIGURATION:
			conf = new Configuration();
			break;
		case DESCRIPTORREF:
			desc = new DescriptorRef();
			break;
		case MANIFEST:
			manifest = new Manifest();
			break;
		case ARCHIVE:
			archive = new Archive();
			break;
		case EXECUTION:
			exec = new Execution();
			break;
		case GOAL:
			goal = new Goal();
			break;
		}
		
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		String nodeText = "";
		for(int i = start;i < start+length;i++) {
			nodeText += ch[i];
		}
		if(!nodeText.trim().isEmpty()) {
		if(currentNode == MODEL_VERSION) {
		  project.setModelVersion(nodeText.trim());
	
		}
		else if(currentNode == GROUP_ID && dep == null) {
		  project.setGroupId(nodeText.trim());		  
		}
		else if(currentNode == ARTIFACT_ID && dep == null && plugin == null) {
			  project.setArtifactId(nodeText.trim());		  
			}
		else if(currentNode == VERSION && dep == null && plugin == null) {
			  project.setVersion(nodeText.trim());		  
			}
		else if(currentNode == NAME) {
			  project.setName(nodeText.trim());		  
			}
		else if(currentNode == URL) {
			  project.setUrl(nodeText.trim());		  
			}
		else if(currentNode == GROUP_ID && dep != null ) {
			  dep.setGroupId(nodeText.trim());		  
			}
		else if(currentNode == ARTIFACT_ID && dep != null && plugin == null) {
			  dep.setArtifactId(nodeText.trim());		  
			}
		else if(currentNode == VERSION && dep != null && plugin == null) {
			  dep.setVersion(Double.parseDouble(nodeText.trim()));		  
			}
		else if(currentNode == SCOPE) {
			 dep.setScope(nodeText.trim());
		}
		else if(currentNode == ARTIFACT_ID && dep != null && plugin != null) {
			  plugin.setArtifactId(nodeText.trim());		  
			}
		else if(currentNode == VERSION && dep != null && plugin != null) {
			  plugin.setVersion(nodeText.trim());		  
			}
		else if(currentNode == DESCRIPTORREF) {
			desc.setDescRef(nodeText.trim());
		}
		else if(currentNode == MAIN_CLASS) {
			manifest.setMainClass(nodeText.trim());
			
		}
		else if(currentNode == ID) {
			exec.setId(nodeText.trim());	
		}	
		else if(currentNode == ID) {
			exec.setId(nodeText.trim());	
		}	
		else if(currentNode == PHASE) {
			exec.setPhase(nodeText.trim());	
		}
		else if(currentNode == GOAL) {
			goal.setGoal(nodeText.trim());	
		}
		}

	}
	
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch(qName) {
		case DEPENDENCY:project.addDep(dep);;
		break;
		case BUILD:project.setBuild(build);
		break;
		case PROJECT:
			projectList.add(project);
			//project.setDep(dep);
		
		}
		
	}
	
	
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(projectList);
		writeToCSV();
	}
	
	private void writeToCSV() {
		try(OutputStream output = new FileOutputStream("project.csv")){
			output.write(makeBytesFromList());
			System.out.println("Write success");
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
	}	
	
	private byte[] makeBytesFromList() {
		StringBuilder sb = new StringBuilder();
		for(Project project: projectList) {
			sb.append(project.toString());
			sb.append("\n");
			
		}
		return sb.toString().getBytes();
	}
}
