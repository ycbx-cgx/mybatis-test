plugins {
    id("java")
}

group = "com.ybx.mybatis"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // 测试
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // 原生MyBatis，不依赖Spring
    implementation("org.mybatis:mybatis:3.5.16")
    // MySQL 驱动
    implementation("com.mysql:mysql-connector-j:26.7.0")
    // Lombok
    implementation("org.projectlombok:lombok:1.18.48")
    annotationProcessor("org.projectlombok:lombok:1.18.48")
    compileOnly("org.projectlombok:lombok:1.18.34")
    // 日志
    implementation("org.slf4j:slf4j-api:2.0.16")
    implementation("org.slf4j:slf4j-simple:2.0.16")
}

tasks.test {
    useJUnitPlatform()
}
// 设置编码，防止中文乱码
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
tasks.withType<JavaExec> {
    jvmArgs("-Dfile.encoding=UTF-8",
        "-Dsun.stdout.encoding=UTF-8",
        "-Dsun.stderr.encoding=UTF-8")
}