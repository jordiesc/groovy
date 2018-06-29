package org.jordiesc.blog
import groovy.util.logging.Slf4j

@Slf4j
class Init {

	static main(args) {
		
	}
	
	public Init() {
		
	}
	
	void crateFileTree() { 
		
		final File blogDir = new File('blog')
	 
			// Remove existing dir, so file contents is
		// only set by the FileTreeBuilder DSL,
		// otherwise content is added to the existing files.
		if (blogDir.exists()) {
		    blogDir.deleteDir()
		}
		 
		blogDir.mkdirs()
		
		final FileTreeBuilder blog = new FileTreeBuilder(blogDir)
		
		
		blog {
		   post {
				 'Foo.groovy'('println "Hello"')
		   }
		   articles {
			  
				 'FooTest.groovy'('class FooTest extends GroovyTestCase {}')
		   }
		      
		   site {
			   'Foo.groovy'
			   'index.html'
			   'rss.xml'
		   }
		   
		}
		
		
		
	}

}
