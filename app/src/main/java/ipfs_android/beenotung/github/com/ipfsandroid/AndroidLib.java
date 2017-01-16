package ipfs_android.beenotung.github.com.ipfsandroid;

import java.io.*;
import java.net.URL;
import java.util.concurrent.*;

/**
 * Created by beenotung on 1/16/17.
 */
public class AndroidLib {
    static class functional {
        interface Maybe<A> {
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

        interface Producer<A> {
            A apply();
        }

        interface Consumer<A> {
            void apply(A a);
        }

        interface Function<A, B> {
            B apply(A a);
        }

        class Pair<A, B> {
            final A a;
            final B b;

            Pair(A a, B b) {
                this.a = a;
                this.b = b;
            }
        }
    }

    static class thread {
        static <A> Future<A> forkAndRun(final lang.Producer<A> f) {
            FutureTask<A> task = new FutureTask<A>(new Callable<A>() {
                @Override
                public A call() throws Exception {
                    return f.apply();
                }
            });
            Executors.newCachedThreadPool().execute(task);
            return task;
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
