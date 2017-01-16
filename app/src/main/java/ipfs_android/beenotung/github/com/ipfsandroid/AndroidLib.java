package ipfs_android.beenotung.github.com.ipfsandroid;

import java.util.Map;

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
}
