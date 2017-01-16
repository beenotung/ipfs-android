package ipfs_android.beenotung.github.com.ipfsandroid;

import android.content.Context;
import ipfs_android.beenotung.github.com.ipfsandroid.AndroidLib.functional.Maybe;

import java.io.File;
import java.io.IOException;

import static ipfs_android.beenotung.github.com.ipfsandroid.AndroidLib.functional.just;
import static ipfs_android.beenotung.github.com.ipfsandroid.AndroidLib.functional.none;
import static ipfs_android.beenotung.github.com.ipfsandroid.AndroidLib.lang.arrayOf;

/**
 * Created by beenotung on 1/16/17.
 */
public class IPFS {
    static File getRepoPath(Context context) {
        return new File(context.getFilesDir(), "ipfs-repo");
    }

    static File getBinaryFile(Context context) {
        return new File(context.getFilesDir(), "ipfsbin");
    }

    static boolean isReady(Context context) {
        return new File(getRepoPath(context), "version").exists();
    }

    static Maybe<String> getBinaryHashByABI(String abi) {
        if (abi.startsWith("x86")) {
            return just("QmZp3wZU4MsU53P8isK5rVCcEdiSig2xdSzxJSEBgAw3Kg");
        } else if (abi.startsWith("arm")) {
            return just("QmRMHb4Vhv8LtYqw8RkDgkdZYxJHfrfFeQaHbNUqJYmdF2");
        }
        return none();
    }

    static Process run(String cmd, Context context) throws IOException {
        String command = getBinaryFile(context).getAbsoluteFile() + " " + cmd;
        String[] env = arrayOf("IPFS_PATH=" + getRepoPath(context).getAbsoluteFile());
        return Runtime.getRuntime().exec(command, env);
    }
//    static void downloadFile()
}
