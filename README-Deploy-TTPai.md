
## ttpai-parents 发布（公司内部）

```bash
# ttpai-parents-build 修改版本
mvn versions:set versions:commit -f ttpai-parents-build/pom.xml

mvn clean install -f ttpai-parents-build/pom.xml

# 修改 ttpai.parents.build.version 属性
vim pom.xml

# #################################################################
# #################################################################

mvn versions:set versions:commit

mvn clean deploy -Pttpai-nexus

```
