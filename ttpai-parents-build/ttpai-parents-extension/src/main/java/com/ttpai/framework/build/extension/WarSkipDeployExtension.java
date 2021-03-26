package com.ttpai.framework.build.extension;

import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.component.annotations.Component;

/**
 * @author zichao.zhang
 */
@Component(role = AbstractMavenLifecycleParticipant.class, hint = "deploy")
public class WarSkipDeployExtension extends AbstractMavenLifecycleParticipant {

    /**
     * 可配置属性
     */
    private static final String SKIP_PROPERTIES = "ttpai.parents.extension.war.skip";

    @Override
    public void afterProjectsRead(MavenSession session) {
        MavenProject currentProject = session.getCurrentProject();

        // 只针对 war 类型的模块
        if (!"war".equals(currentProject.getPackaging())) {
            return;
        }

        // 该功能是否被跳过
        String skipConfig = currentProject.getProperties().getProperty(SKIP_PROPERTIES, "false");
        if ("true".equalsIgnoreCase(skipConfig)) {
            return;
        }


        String projectName = currentProject.getName();
        System.out.println("========== Packaging Is War: " + projectName + ", Will Skip install & deploy ==========");

        currentProject.getProperties().setProperty("maven.deploy.skip", "true");
        currentProject.getProperties().setProperty("maven.install.skip", "true");
    }

}
