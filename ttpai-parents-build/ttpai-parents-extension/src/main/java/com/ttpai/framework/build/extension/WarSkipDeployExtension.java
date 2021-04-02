package com.ttpai.framework.build.extension;

import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.component.annotations.Component;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author zichao.zhang
 */
@Component(role = AbstractMavenLifecycleParticipant.class, hint = "deploy")
public class WarSkipDeployExtension extends AbstractExtension {

    /**
     * 可配置属性
     */
    private static final String SKIP_PROPERTIES = "ttpai.parents.extension.war.skip";

    @Nullable
    @Override
    public String skipProperties() {
        return SKIP_PROPERTIES;
    }

    @Override
    public void afterProjectsReadPretty(MavenSession session) {
        // 处理所有模块
        List<MavenProject> allProjects = session.getAllProjects();
        for (MavenProject currentProject : allProjects) {
            projectHandler(currentProject);
        }

    }

    /**
     * 处理项目配置
     * <p>
     * session.getCurrentProject() 只有 父 pom 会执行
     */
    protected void projectHandler(MavenProject currentProject) {
        String projectName = currentProject.getName();
        String packaging = currentProject.getPackaging();

        // 只针对 war 类型的模块
        if (!"war".equals(packaging)) {
            logger.info(" {} packaging is not war ({}), This extension will Skip ", projectName, packaging);
            return;
        }

        // 该功能是否被跳过
        if (shouldSkip(currentProject.getProperties())) {
            logger.info("{} <{}>true</{}>,  will Skip", projectName, skipProperties(), skipProperties());
            return;
        }

        logger.info(" {} packaging is war, will skip install & deploy", projectName);

        currentProject.getProperties().setProperty("maven.deploy.skip", "true");
        currentProject.getProperties().setProperty("maven.install.skip", "true");
    }

}
