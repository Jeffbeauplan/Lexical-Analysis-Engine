/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package techx.sopl.pr01;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import org.apache.commons.text.StringEscapeUtils;

import org.junit.Test;

public class Pr01Test {

    @Test
    public void testRuns() {
        //Valid (with escapte characters)
        String input = "\t";
        String program = "0 SPLIT 1 3\n1 CHAR 9 10\n2 JMP 4\n3 CHAR 97 97\n4 MATCH";
        int exitCode = Pr01.tokenizeInput(new Config("path", input.getBytes()), program);
        assertEquals("run should have a 0 exit code", 0, exitCode);
        
        //Valid
        input = "name 23.7e4 keyword john";
        program = "0 SPLIT 1 9\r\n1 CHAR 107 107\r\n2 CHAR 101 101\r\n3 CHAR 121 121\r\n4 CHAR 119 119\r\n5 CHAR 111 111\r\n6 CHAR 114 114\r\n7 CHAR 100 100\r\n8 MATCH\r\n9 SPLIT 10 27\r\n10 SPLIT 11 13\r\n11 CHAR 97 122\r\n12 JMP 17\r\n13 SPLIT 14 16\r\n14 CHAR 65 90\r\n15 JMP 17\r\n16 CHAR 95 95\r\n17 SPLIT 18 26\r\n18 SPLIT 19 21\r\n19 CHAR 97 122\r\n20 JMP 25\r\n21 SPLIT 22 24\r\n22 CHAR 65 90\r\n23 JMP 25\r\n24 CHAR 95 95\r\n25 JMP 17\r\n26 MATCH\r\n27 SPLIT 28 52\r\n28 SPLIT 29 31\r\n29 CHAR 48 57\r\n30 JMP 28\r\n31 SPLIT 32 33\r\n32 CHAR 46 46\r\n33 CHAR 48 57\r\n34 SPLIT 35 37\r\n35 CHAR 48 57\r\n36 JMP 34\r\n37 SPLIT 38 51\r\n38 SPLIT 39 41\r\n39 CHAR 69 69\r\n40 JMP 42\r\n41 CHAR 101 101\r\n42 SPLIT 43 47\r\n43 SPLIT 44 46\r\n44 CHAR 43 43\r\n45 JMP 47\r\n46 CHAR 45 45\r\n47 CHAR 48 57\r\n48 SPLIT 49 51\r\n49 CHAR 48 57\r\n50 JMP 48\r\n51 MATCH\r\n52 SPLIT 53 55\r\n53 CHAR 32 32\r\n54 JMP 59\r\n55 SPLIT 56 58\r\n56 CHAR 9 9\r\n57 JMP 59\r\n58 CHAR 10 10\r\n59 SPLIT 60 68\r\n60 SPLIT 61 63\r\n61 CHAR 32 32\r\n62 JMP 67\r\n63 SPLIT 64 66\r\n64 CHAR 9 9\r\n65 JMP 67\r\n66 CHAR 10 10\r\n67 JMP 59\r\n68 MATCH";
        program = program.replaceAll("\\r", "");
        exitCode = Pr01.tokenizeInput(new Config("path", input.getBytes()), program);
        assertEquals("run should have a 0 exit code", 0, exitCode);
        
        //Invalid lexeme (no matches)
        input = "t";
        program = "0 SPLIT 1 3\n1 CHAR 9 10\n2 JMP 4\n3 CHAR 97 97\n4 MATCH";
        exitCode = Pr01.tokenizeInput(new Config("path", input.getBytes()), program);
        assertEquals("run should have a 1 exit code", 1, exitCode);
        
        //Empty String
        input = "";
        program = "0 SPLIT 1 3\n1 CHAR 9 10\n2 JMP 4\n3 CHAR 97 97\n4 MATCH";
        exitCode = Pr01.tokenizeInput(new Config("path", input.getBytes()), program);
        assertEquals("run should have a 1 exit code", 1, exitCode);
        
        //Misspelled instruction
        input = "\t";
        program = "0 SPLT 1 3\n1 CHAR 9 10\n2 JMP 4\n3 CHAR 97 97\n4 MATCH";
        exitCode = Pr01.tokenizeInput(new Config("path", input.getBytes()), program);
        assertEquals("run should have a 1 exit code", 1, exitCode);
        
        //Invalid Jump instruction (out of range)
        input = "\t";
        program = "0 SPLT 1 3\n1 CHAR 9 10\n2 JMP 7\n3 CHAR 97 97\n4 MATCH";
        exitCode = Pr01.tokenizeInput(new Config("path", input.getBytes()), program);
        assertEquals("run should have a 1 exit code", 1, exitCode);
        
        //Invalid Split instruction (out of range)
        input = "\t";
        program = "0 SPLT 1 8\n1 CHAR 9 10\n2 JMP 4\n3 CHAR 97 97\n4 MATCH";
        exitCode = Pr01.tokenizeInput(new Config("path", input.getBytes()), program);
        assertEquals("run should have a 1 exit code", 1, exitCode);
        
    }  
}