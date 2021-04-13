
### v2.2.3 2021-04-13

- javadoc 插件默认跳过，ossrh 不跳过
- 仓库 IP 改为域名
- [fix #6] maven-dependency-plugin 插件 打 jar 包的时候会包含 test 和 provided 的 jar 包 到 lib 下 

### v2.2.2 2021-04-02

- ossrh 完善，增加 javadoc 插件

### v2.2.1 2021-03-26

- 项目类型为 war 时跳过 install 和 deploy

### v2.2.0 2021-03-26
- 整合 parent1 和 parent2
- 支持 Maven 中央仓库发布 先关配置
- 依赖版本
  - slf4j-api: 1.7.26 ↑ 1.7.30
  - druid: 1.1.17 ↑ 1.1.21
  - powermock: 2.0.9
  - mockito: 3.3.3
  - junit5: 5.7.1

### v1.3.9 2021-02-04
- MyBatis 支持
- junit ↑ 4.13.1
- pom -> build -> resources，支持 MyBatis 的 Mapper.xml copy，避免 Mapper 找不到映射文件

