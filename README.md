# Verschlüsselung und Entschlüsselung in der Chuck-Norris-Kodierung

## Verschlüsselung

Die Verschlüsselung wandelt einen lesbaren Text in das **Chuck-Norris-Format** um.

### Schritte der Verschlüsselung

1. **Eingabe des Textes**:
   - Der Benutzer gibt einen Text ein, z. B.:
     ```
     H W!
     ```

2. **Umwandlung der Zeichen in Binärformat**:
   - Jedes Zeichen wird in einen **7-Bit-Binärwert** (ASCII) umgewandelt:
     - `H` → `1001000`
     - ` ` → `0100000`
     - `W` → `1010111`
     - `!` → `0100001`

3. **Erstellung des Chuck-Norris-Formats**:
   - Der Binärstring wird in Blöcke aus `"0"` und `"00"` umgewandelt:
     - `"0"` bedeutet `1` gefolgt von einer Anzahl an `0`.
     - `"00"` bedeutet `0` gefolgt von einer Anzahl an `0`.
   - Beispiel:
     - `1001000` → `0 0 00 0000 0 00 0 0`
     - `0100000` → `00 0 0 0000 00 0`
     - `1010111` → `0 0 00 0 0 00 00 00 000 0`
     - `0100001` → `00 0 0 0000 00 0 0 0`

4. **Ausgabe**:
   - Der verschlüsselte Text wird im Chuck-Norris-Format ausgegeben:
     ```
     0 0 00 0000 0 00 0 0 00 0 0 0000 00 0 0 00 00 00 000 0
     ```

---

## Entschlüsselung

Die Entschlüsselung wandelt eine Zeichenkette im **Chuck-Norris-Format** zurück in einen lesbaren Text.

### Schritte der Entschlüsselung

1. **Eingabe der kodierten Zeichenkette**:
   - Der Benutzer gibt eine kodierte Zeichenkette ein, z. B.:
     ```
     0 0 00 0000 0 00 0 0
     ```

2. **Umwandlung in Binärformat**:
   - Die kodierte Zeichenkette wird in einen Binärstring umgewandelt:
     - `"0 0"` → `1`
     - `"00 0000"` → `0000`
     - `"0 00"` → `1`
     - `"0 0"` → `1`
   - Ergebnis:
     ```
     1001000
     ```

3. **Aufteilen in 7-Bit-Blöcke**:
   - Der Binärstring wird in Blöcke von 7 Bits aufgeteilt (ASCII-Basis):
     - `1001000`

4. **Konvertierung in lesbaren Text**:
   - Jeder 7-Bit-Block wird in sein ASCII-Äquivalent umgewandelt:
     - `1001000` → `H`

5. **Ausgabe**:
   - Der entschlüsselte Text wird ausgegeben:
     ```
     H
     ```

---

## Menü und Steuerung

Das Programm bietet ein einfaches Menü, über das der Benutzer zwischen verschiedenen Optionen wählen kann. Nach jedem Vorgang kehrt das Programm automatisch zum Hauptmenü zurück.

### Menüoptionen

1. **`encode`**:
   - Wandelt eine Eingabezeichenkette in das **Chuck-Norris-Format** um.
   - Nach der Eingabe eines Textes wird die kodierte Zeichenkette angezeigt.
   - Beispiel:
     ```
     Please input operation (encode/decode/exit):
     > encode
     Input string:
     > Hello
     Encoded string:
     0 0 00 0000 0 00 0 0 00 00 0 000 00 0 0 00
     ```

2. **`decode`**:
   - Wandelt eine Zeichenkette im **Chuck-Norris-Format** in einen lesbaren Text um.
   - Nach der Eingabe einer kodierten Zeichenkette wird der ursprüngliche Text angezeigt.
   - Beispiel:
     ```
     Please input operation (encode/decode/exit):
     > decode
     Input encoded string:
     > 0 0 00 0000 0 00
     Decoded string:
     H
     ```

3. **`exit`**:
   - Beendet das Programm.
   - Beispiel:
     ```
     Please input operation (encode/decode/exit):
     > exit
     Bye!
     ```

### Fehlermeldungen

- **Ungültige Eingabe**:
  - Wenn eine ungültige Option eingegeben wird (z. B. `Hello world!`), gibt das Programm eine Fehlermeldung aus und kehrt zum Hauptmenü zurück.
  - Beispiel:
    ```
    Please input operation (encode/decode/exit):
    > invalid
    There is no 'invalid' operation
    ```

- **Ungültiges Chuck-Norris-Format**:
  - Wenn eine ungültige kodierte Zeichenkette eingegeben wird, zeigt das Programm eine Fehlermeldung an:
    ```
    Please input operation (encode/decode/exit):
    > decode
    Input encoded string:
    > invalid format
    Not valid encoded string
    ```

### Ablauf

1. Das Programm zeigt das Hauptmenü:
2. Der Benutzer gibt eine Option ein (`encode`, `decode` oder `exit`).
3. Nach Abschluss eines Vorgangs oder einer Fehlermeldung kehrt das Programm zum Hauptmenü zurück.
4. Das Programm wird nur beendet, wenn der Benutzer `exit` eingibt.
