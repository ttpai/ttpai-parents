## ttpai-parents 发布

```bash
# ttpai-parents-build 修改版本
mvn versions:set versions:commit -f ttpai-parents-build/pom.xml

mvn clean install -f ttpai-parents-build/pom.xml

# 修改 ttpai.parents.build.version 属性
vim pom.xml

# ttpai-parents-build 需要先发布
mvn clean deploy -f ttpai-parents-build/pom.xml -Pttpai-nexus

# #################################################################
# #################################################################

mvn versions:set versions:commit

mvn clean deploy -Pttpai-nexus

```
