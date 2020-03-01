# Program AB: Sprint's fork

Fork of [Program AB](http://alicebot.blogspot.co.id/2013/01/program-ab-aiml-20-reference.html), the reference implementation of the AIML 2.0 draft specification. AIML is a widely adopted standard for creating chat bots and mobile virtual assistants like ALICE, Mitsuku, English Tutor, The Professor, S.U.P.E.R. and many more.

Added support of polish langage, using dictionary from morfologik stemming. Supports enable or disable Polish diacritical marks in AIML file.   


## Usage - Use Soluvas's Repository

### In Maven project

    <repositories>
        <repository>
            <id>soluvas-public-snapshots</id>
            <url>http://nexus.bippo.co.id/nexus/content/repositories/soluvas-public-snapshots/</url>
            <releases>
                <enabled>false</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>org.alicebot.ab</groupId>
            <artifactId>ab</artifactId>
            <version>4.0.5_SPRINT</version>
        </dependency>
    </dependencies>

#

## Usage - Build Yourself

1. Build using [Maven](http://maven.apache.org) to your local Maven repository:

        mvn -DskipTests install

2. Use in your Maven project:

        <dependencies>
            <dependency>
                <groupId>org.alicebot.ab</groupId>
                <artifactId>ab</artifactId>
                <version>4.0.5_SPRINT</version>
            </dependency>
        </dependencies>

    
    
## TODO 

1. Build entirely with Maven, without embedded JARs in project sources [done]
2. Replace System.out.println with SLF4J logging [done]
3. Replace ex.printStackTrace(); with detailed Exception [partial]
4. Replace commons-logging dependency with SLF4J 1.6/1.7 [done]
5. -Allow loading bot data files from classpath- (too complex, and probably non-performant in Android anyway, alternative: extract the bot ZIP file to @getCacheDir()@)  
6. Replace json dependency with jackson 2.2
7. Run well with Android Gingerbread (API 9)
