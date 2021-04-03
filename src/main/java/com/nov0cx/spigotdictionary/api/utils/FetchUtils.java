package com.nov0cx.spigotdictionary.api.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.UUID;

import org.bukkit.entity.Player;


/* https://www.spigotmc.org/threads/uuid-fetcher.172593/ */
public class FetchUtils {
    /**
     * Helper-class for getting names of players.
     * <p>Attention! Run these methods async because they block the main thread.</p>
     */
    public static class NameFetcher {
        private static final String NAME_URL = "https://sessionserver.mojang.com"
                + "/session/minecraft/profile/";

        private NameFetcher() {
            throw new UnsupportedOperationException();
        }

        /**
         * Returns the name of the searched player.
         *
         * @param uuid The UUID of a player.
         * @return The name of the given player.
         */
        public static String getName(UUID uuid) {
            return getName(uuid.toString());
        }

        /**
         * Returns the name of the searched player.
         *
         * @param uuid The UUID of a player (can be trimmed or the normal version).
         * @return The name of the given player.
         */
        public static String getName(String uuid) {
            uuid = uuid.replace("-", "");
            String output = callURL(NAME_URL + uuid);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 20000; i++) {
                if (output.charAt(i) == 'n' && output.charAt(i + 1) == 'a'
                        && output.charAt(i + 2) == 'm'
                        && output.charAt(i + 3) == 'e') {
                    for (int k = i + 9; k < 20000; k++) {
                        char curr = output.charAt(k);
                        if (curr != '"') {
                            result.append(curr);
                        } else {
                            break;
                        }
                    }
                    break;
                }
            }
            return result.toString();
        }

        private static String callURL(String urlStr) {
            StringBuilder sb = new StringBuilder();
            URLConnection urlConn;
            InputStreamReader in;
            try {
                URL url = new URL(urlStr);
                urlConn = url.openConnection();
                if (urlConn != null) {
                    urlConn.setReadTimeout(60 * 1000);
                }
                if (urlConn != null && urlConn.getInputStream() != null) {
                    in = new InputStreamReader(urlConn.getInputStream(),
                            Charset.defaultCharset());
                    BufferedReader bufferedReader = new BufferedReader(in);
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sb.toString();
        }
    }

    /**
     * Helper-class for getting uuid of players.
     * <p>Attention! Run these methods async because they block the main thread.</p>
     */
    public static class UUIDFetcher {
        private static final String UUID_URL = "https://api.mojang.com/users"
                + "/profiles/minecraft/";

        private UUIDFetcher() {
            throw new UnsupportedOperationException();
        }


        /**
         * Returns the UUID of the searched player.
         *
         * @param player The player.
         * @return The UUID of the given player.
         */
        public static UUID getUUID(Player player) {
            return getUUID(player.getName());
        }


        /**
         * Returns the UUID of the searched player.
         *
         * @param playername The name of the player.
         * @return The UUID of the given player.
         */
        public static UUID getUUID(String playername) {
            String output = callURL(UUID_URL + playername);
            StringBuilder result = new StringBuilder();
            readData(output, result);
            String u = result.toString();
            StringBuilder uuid = new StringBuilder();
            for (int i = 0; i <= 31; i++) {
                uuid.append(u.charAt(i));
                if (i == 7 || i == 11 || i == 15 || i == 19) {
                    uuid.append('-');
                }
            }
            return UUID.fromString(uuid.toString());
        }

        private static void readData(String toRead, StringBuilder result) {
            for (int i = toRead.length() - 3; i >= 0; i--) {
                if (toRead.charAt(i) != '"') {
                    result.insert(0, toRead.charAt(i));
                } else {
                    break;
                }
            }
        }

        private static String callURL(String urlStr) {
            StringBuilder sb = new StringBuilder();
            URLConnection urlConn;
            InputStreamReader in;
            try {
                URL url = new URL(urlStr);
                urlConn = url.openConnection();
                if (urlConn != null) {
                    urlConn.setReadTimeout(60 * 1000);
                }
                if (urlConn != null && urlConn.getInputStream() != null) {
                    in = new InputStreamReader(urlConn.getInputStream(),
                            Charset.defaultCharset());
                    BufferedReader bufferedReader = new BufferedReader(in);
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sb.toString();
        }

    }
}
