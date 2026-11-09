
package fileupload.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

import fileupload.base.BaseTest;
import fileupload.pages.UploadPage;

public class UploadTests extends BaseTest {

    private List<Path> getTestFiles() throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get("testdata"))) {
            List<Path> files = stream
                    .filter(Files::isRegularFile)
                    .filter(f -> !f.getFileName().toString()
                            .equalsIgnoreCase("README.txt"))
                    .sorted()
                    .collect(Collectors.toList());

            Assert.assertFalse(files.isEmpty(),
                    "The testdata folder has no files");

            return files;
        }
    }

    @Test(description = "Upload one file")
    public void singleFileUpload() throws IOException {
        Path file = getTestFiles().get(0);

        UploadPage page = new UploadPage(driver);
        page.uploadFiles(List.of(file));
    }

    @Test(description = "Upload all files from testdata together")
    public void multipleFileUpload() throws IOException {
        List<Path> files = getTestFiles();

        Assert.assertTrue(files.size() >= 2,
                "Put at least 2 files in testdata");

        UploadPage page = new UploadPage(driver);
        page.uploadFiles(files);
    }
}
