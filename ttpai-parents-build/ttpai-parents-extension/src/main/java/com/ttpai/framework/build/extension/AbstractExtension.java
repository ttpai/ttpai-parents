package com.ttpai.framework.build.extension;

import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.execution.MavenSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.util.Properties;

/**
 * @author kail
 */
public abstract class AbstractExtension extends AbstractMavenLifecycleParticipant {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 控制属性
     */
    @Nullable
    public abstract String skipProperties();

    /**
     * 是否应该跳过
     */
    protected boolean shouldSkip(Properties properties) {
        String skipConfig = properties.getProperty(skipProperties(), "false");
        return "true".equalsIgnoreCase(skipConfig);
    }


    @Override
    public void afterProjectsRead(MavenSession session) {
        logger.info("");
        logger.info("");
        logger.info("===============================================================================================");
        logger.info("ttpai-parents-extension${} is Starting...", getClass().getSimpleName());

        // region 跳过逻辑
        boolean skip = false;
        String skipProperties = skipProperties();
        // 有配置跳过属性
        if (null != skipProperties && skipProperties.length() > 0) {
            logger.info("you can use {} (true/false) to skip is extension", skipProperties());
            //
            // 获取跳过属性
            skip = skip ? skip : this.shouldSkip(session.getCurrentProject().getProperties());
            skip = skip ? skip : this.shouldSkip(session.getUserProperties());
            skip = skip ? skip : this.shouldSkip(session.getSystemProperties());
            if (skip) {
                logger.info("{}=true,  will Skip", skipProperties());
            }
        }
        // endregion

        //
        if (!skip) {
            logger.info("");
            this.afterProjectsReadPretty(session);
            logger.info("");
        }
        //
        //
        logger.info("ttpai-parents-extension${} is End...", getClass().getSimpleName());
        logger.info("===============================================================================================");
        logger.info("");
        logger.info("");
    }


    /**
     * @see AbstractMavenLifecycleParticipant#afterProjectsRead(MavenSession)
     */
    public abstract void afterProjectsReadPretty(MavenSession session);

}
