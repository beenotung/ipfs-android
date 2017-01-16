package ipfs_android.beenotung.github.com.ipfsandroid;

import java.io.*;
import java.net.URL;

/**
 * Created by beenotung on 1/16/17.
 */
public class AndroidLib {
    static class functional {
        static interface Maybe<A> {
            A getValue();

            boolean isJust();
        }

        static <A> Maybe<A> just(final A a) {
            return new Maybe<A>() {
                @Override
                public A getValue() {
                    return a;
                }

                @Override
                public boolean isJust() {
                    return true;
                }
            };
        }

        static <A> Maybe<A> none() {
            return new Maybe<A>() {
                @Override
                public A getValue() {
                    throw new IllegalStateException("this is maybe of none");
                }

                @Override
                public boolean isJust() {
                    return false;
                }
            };
        }
    }

    static class lang {
        static <A> A[] arrayOf(A... args) {
            return args;
        }
    }

    static class network {
        static int bufferSize = 1024;

        static void httpsDownloadFile(URL url, File output) throws IOException {
            FileOutputStream outputStream = new FileOutputStream(output);
            byte[] buffer = new byte[bufferSize];
            int len = 0;
            InputStream inputStream = url.openStream();
            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
        }
    }
}
