package chapter01;

import java.io.File;
import java.io.FileFilter;

public class hiddenFile {
    public static void main(String[] args) {
        // 기존의 숨겨진 파일 필터링 방식
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        /* 자바 8 이후
         * 메서드 참조 문법(::)을 사용해 직접 isHidden 함수를 listFiles 메서드로 전달 */
        File[] hiddenFilesByJava8 = new File(".").listFiles(File::isHidden);
    }
}
