
## ttpai-parents 发布（中央仓库）

```bash
# ttpai-parents-build 修改版本
mvn versions:set versions:commit -f ttpai-parents-build/pom.xml

mvn clean install -f ttpai-parents-build/pom.xml -Possrh

# 修改 ttpai.parents.build.version 属性
vim pom.xml

# #################################################################
# #################################################################

mvn versions:set versions:commit

mvn clean deploy -Possrh

```
