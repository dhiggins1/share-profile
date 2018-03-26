package com.daraghhiggins.shareprofile.Utils;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class UserUtility {
    public String hash(String raw) {
        return Hashing.sha256().hashString(raw, StandardCharsets.UTF_8).toString();
    }
}
