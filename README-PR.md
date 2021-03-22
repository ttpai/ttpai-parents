
## PR

```bash
sed -i '' 's@<groupId>xyz.kail.framework</groupId>@<groupId>com.ttpai.framework</groupId>@g' \
  `grep '<groupId>xyz.kail.framework</groupId>' --include=pom.xml -rl .`
```