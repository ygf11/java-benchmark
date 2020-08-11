/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package ygf.serialize.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class AvroPerson extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2828270892594419733L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvroPerson\",\"namespace\":\"ygf.serialize.avro\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"age\",\"type\":\"int\"},{\"name\":\"desc\",\"type\":\"string\"},{\"name\":\"friends\",\"type\":[{\"type\":\"array\",\"items\":\"AvroPerson\",\"default\":[]},\"null\"]},{\"name\":\"relatives\",\"type\":[{\"type\":\"map\",\"values\":\"AvroPerson\"},\"null\"]},{\"name\":\"hobbies\",\"type\":[{\"type\":\"array\",\"items\":\"string\",\"default\":[]},\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AvroPerson> ENCODER =
      new BinaryMessageEncoder<AvroPerson>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AvroPerson> DECODER =
      new BinaryMessageDecoder<AvroPerson>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<AvroPerson> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<AvroPerson> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<AvroPerson> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<AvroPerson>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this AvroPerson to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a AvroPerson from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a AvroPerson instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static AvroPerson fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence name;
   private int age;
   private java.lang.CharSequence desc;
   private java.util.List<ygf.serialize.avro.AvroPerson> friends;
   private java.util.Map<java.lang.CharSequence,ygf.serialize.avro.AvroPerson> relatives;
   private java.util.List<java.lang.CharSequence> hobbies;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AvroPerson() {}

  /**
   * All-args constructor.
   * @param name The new value for name
   * @param age The new value for age
   * @param desc The new value for desc
   * @param friends The new value for friends
   * @param relatives The new value for relatives
   * @param hobbies The new value for hobbies
   */
  public AvroPerson(java.lang.CharSequence name, java.lang.Integer age, java.lang.CharSequence desc, java.util.List<ygf.serialize.avro.AvroPerson> friends, java.util.Map<java.lang.CharSequence,ygf.serialize.avro.AvroPerson> relatives, java.util.List<java.lang.CharSequence> hobbies) {
    this.name = name;
    this.age = age;
    this.desc = desc;
    this.friends = friends;
    this.relatives = relatives;
    this.hobbies = hobbies;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return age;
    case 2: return desc;
    case 3: return friends;
    case 4: return relatives;
    case 5: return hobbies;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.CharSequence)value$; break;
    case 1: age = (java.lang.Integer)value$; break;
    case 2: desc = (java.lang.CharSequence)value$; break;
    case 3: friends = (java.util.List<ygf.serialize.avro.AvroPerson>)value$; break;
    case 4: relatives = (java.util.Map<java.lang.CharSequence,ygf.serialize.avro.AvroPerson>)value$; break;
    case 5: hobbies = (java.util.List<java.lang.CharSequence>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'age' field.
   * @return The value of the 'age' field.
   */
  public int getAge() {
    return age;
  }


  /**
   * Sets the value of the 'age' field.
   * @param value the value to set.
   */
  public void setAge(int value) {
    this.age = value;
  }

  /**
   * Gets the value of the 'desc' field.
   * @return The value of the 'desc' field.
   */
  public java.lang.CharSequence getDesc() {
    return desc;
  }


  /**
   * Sets the value of the 'desc' field.
   * @param value the value to set.
   */
  public void setDesc(java.lang.CharSequence value) {
    this.desc = value;
  }

  /**
   * Gets the value of the 'friends' field.
   * @return The value of the 'friends' field.
   */
  public java.util.List<ygf.serialize.avro.AvroPerson> getFriends() {
    return friends;
  }


  /**
   * Sets the value of the 'friends' field.
   * @param value the value to set.
   */
  public void setFriends(java.util.List<ygf.serialize.avro.AvroPerson> value) {
    this.friends = value;
  }

  /**
   * Gets the value of the 'relatives' field.
   * @return The value of the 'relatives' field.
   */
  public java.util.Map<java.lang.CharSequence,ygf.serialize.avro.AvroPerson> getRelatives() {
    return relatives;
  }


  /**
   * Sets the value of the 'relatives' field.
   * @param value the value to set.
   */
  public void setRelatives(java.util.Map<java.lang.CharSequence,ygf.serialize.avro.AvroPerson> value) {
    this.relatives = value;
  }

  /**
   * Gets the value of the 'hobbies' field.
   * @return The value of the 'hobbies' field.
   */
  public java.util.List<java.lang.CharSequence> getHobbies() {
    return hobbies;
  }


  /**
   * Sets the value of the 'hobbies' field.
   * @param value the value to set.
   */
  public void setHobbies(java.util.List<java.lang.CharSequence> value) {
    this.hobbies = value;
  }

  /**
   * Creates a new AvroPerson RecordBuilder.
   * @return A new AvroPerson RecordBuilder
   */
  public static ygf.serialize.avro.AvroPerson.Builder newBuilder() {
    return new ygf.serialize.avro.AvroPerson.Builder();
  }

  /**
   * Creates a new AvroPerson RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AvroPerson RecordBuilder
   */
  public static ygf.serialize.avro.AvroPerson.Builder newBuilder(ygf.serialize.avro.AvroPerson.Builder other) {
    if (other == null) {
      return new ygf.serialize.avro.AvroPerson.Builder();
    } else {
      return new ygf.serialize.avro.AvroPerson.Builder(other);
    }
  }

  /**
   * Creates a new AvroPerson RecordBuilder by copying an existing AvroPerson instance.
   * @param other The existing instance to copy.
   * @return A new AvroPerson RecordBuilder
   */
  public static ygf.serialize.avro.AvroPerson.Builder newBuilder(ygf.serialize.avro.AvroPerson other) {
    if (other == null) {
      return new ygf.serialize.avro.AvroPerson.Builder();
    } else {
      return new ygf.serialize.avro.AvroPerson.Builder(other);
    }
  }

  /**
   * RecordBuilder for AvroPerson instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvroPerson>
    implements org.apache.avro.data.RecordBuilder<AvroPerson> {

    private java.lang.CharSequence name;
    private int age;
    private java.lang.CharSequence desc;
    private java.util.List<ygf.serialize.avro.AvroPerson> friends;
    private java.util.Map<java.lang.CharSequence,ygf.serialize.avro.AvroPerson> relatives;
    private java.util.List<java.lang.CharSequence> hobbies;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(ygf.serialize.avro.AvroPerson.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.age)) {
        this.age = data().deepCopy(fields()[1].schema(), other.age);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.desc)) {
        this.desc = data().deepCopy(fields()[2].schema(), other.desc);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.friends)) {
        this.friends = data().deepCopy(fields()[3].schema(), other.friends);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.relatives)) {
        this.relatives = data().deepCopy(fields()[4].schema(), other.relatives);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.hobbies)) {
        this.hobbies = data().deepCopy(fields()[5].schema(), other.hobbies);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
    }

    /**
     * Creates a Builder by copying an existing AvroPerson instance
     * @param other The existing instance to copy.
     */
    private Builder(ygf.serialize.avro.AvroPerson other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.age)) {
        this.age = data().deepCopy(fields()[1].schema(), other.age);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.desc)) {
        this.desc = data().deepCopy(fields()[2].schema(), other.desc);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.friends)) {
        this.friends = data().deepCopy(fields()[3].schema(), other.friends);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.relatives)) {
        this.relatives = data().deepCopy(fields()[4].schema(), other.relatives);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.hobbies)) {
        this.hobbies = data().deepCopy(fields()[5].schema(), other.hobbies);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public ygf.serialize.avro.AvroPerson.Builder setName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public ygf.serialize.avro.AvroPerson.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'age' field.
      * @return The value.
      */
    public int getAge() {
      return age;
    }


    /**
      * Sets the value of the 'age' field.
      * @param value The value of 'age'.
      * @return This builder.
      */
    public ygf.serialize.avro.AvroPerson.Builder setAge(int value) {
      validate(fields()[1], value);
      this.age = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'age' field has been set.
      * @return True if the 'age' field has been set, false otherwise.
      */
    public boolean hasAge() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'age' field.
      * @return This builder.
      */
    public ygf.serialize.avro.AvroPerson.Builder clearAge() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'desc' field.
      * @return The value.
      */
    public java.lang.CharSequence getDesc() {
      return desc;
    }


    /**
      * Sets the value of the 'desc' field.
      * @param value The value of 'desc'.
      * @return This builder.
      */
    public ygf.serialize.avro.AvroPerson.Builder setDesc(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.desc = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'desc' field has been set.
      * @return True if the 'desc' field has been set, false otherwise.
      */
    public boolean hasDesc() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'desc' field.
      * @return This builder.
      */
    public ygf.serialize.avro.AvroPerson.Builder clearDesc() {
      desc = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'friends' field.
      * @return The value.
      */
    public java.util.List<ygf.serialize.avro.AvroPerson> getFriends() {
      return friends;
    }


    /**
      * Sets the value of the 'friends' field.
      * @param value The value of 'friends'.
      * @return This builder.
      */
    public ygf.serialize.avro.AvroPerson.Builder setFriends(java.util.List<ygf.serialize.avro.AvroPerson> value) {
      validate(fields()[3], value);
      this.friends = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'friends' field has been set.
      * @return True if the 'friends' field has been set, false otherwise.
      */
    public boolean hasFriends() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'friends' field.
      * @return This builder.
      */
    public ygf.serialize.avro.AvroPerson.Builder clearFriends() {
      friends = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'relatives' field.
      * @return The value.
      */
    public java.util.Map<java.lang.CharSequence,ygf.serialize.avro.AvroPerson> getRelatives() {
      return relatives;
    }


    /**
      * Sets the value of the 'relatives' field.
      * @param value The value of 'relatives'.
      * @return This builder.
      */
    public ygf.serialize.avro.AvroPerson.Builder setRelatives(java.util.Map<java.lang.CharSequence,ygf.serialize.avro.AvroPerson> value) {
      validate(fields()[4], value);
      this.relatives = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'relatives' field has been set.
      * @return True if the 'relatives' field has been set, false otherwise.
      */
    public boolean hasRelatives() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'relatives' field.
      * @return This builder.
      */
    public ygf.serialize.avro.AvroPerson.Builder clearRelatives() {
      relatives = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'hobbies' field.
      * @return The value.
      */
    public java.util.List<java.lang.CharSequence> getHobbies() {
      return hobbies;
    }


    /**
      * Sets the value of the 'hobbies' field.
      * @param value The value of 'hobbies'.
      * @return This builder.
      */
    public ygf.serialize.avro.AvroPerson.Builder setHobbies(java.util.List<java.lang.CharSequence> value) {
      validate(fields()[5], value);
      this.hobbies = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'hobbies' field has been set.
      * @return True if the 'hobbies' field has been set, false otherwise.
      */
    public boolean hasHobbies() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'hobbies' field.
      * @return This builder.
      */
    public ygf.serialize.avro.AvroPerson.Builder clearHobbies() {
      hobbies = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AvroPerson build() {
      try {
        AvroPerson record = new AvroPerson();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.age = fieldSetFlags()[1] ? this.age : (java.lang.Integer) defaultValue(fields()[1]);
        record.desc = fieldSetFlags()[2] ? this.desc : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.friends = fieldSetFlags()[3] ? this.friends : (java.util.List<ygf.serialize.avro.AvroPerson>) defaultValue(fields()[3]);
        record.relatives = fieldSetFlags()[4] ? this.relatives : (java.util.Map<java.lang.CharSequence,ygf.serialize.avro.AvroPerson>) defaultValue(fields()[4]);
        record.hobbies = fieldSetFlags()[5] ? this.hobbies : (java.util.List<java.lang.CharSequence>) defaultValue(fields()[5]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AvroPerson>
    WRITER$ = (org.apache.avro.io.DatumWriter<AvroPerson>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AvroPerson>
    READER$ = (org.apache.avro.io.DatumReader<AvroPerson>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.name);

    out.writeInt(this.age);

    out.writeString(this.desc);

    if (this.friends == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      long size0 = this.friends.size();
      out.writeArrayStart();
      out.setItemCount(size0);
      long actualSize0 = 0;
      for (ygf.serialize.avro.AvroPerson e0: this.friends) {
        actualSize0++;
        out.startItem();
        e0.customEncode(out);
      }
      out.writeArrayEnd();
      if (actualSize0 != size0)
        throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");
    }

    if (this.relatives == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      long size1 = this.relatives.size();
      out.writeMapStart();
      out.setItemCount(size1);
      long actualSize1 = 0;
      for (java.util.Map.Entry<java.lang.CharSequence, ygf.serialize.avro.AvroPerson> e1: this.relatives.entrySet()) {
        actualSize1++;
        out.startItem();
        out.writeString(e1.getKey());
        ygf.serialize.avro.AvroPerson v1 = e1.getValue();
        v1.customEncode(out);
      }
      out.writeMapEnd();
      if (actualSize1 != size1)
      throw new java.util.ConcurrentModificationException("Map-size written was " + size1 + ", but element count was " + actualSize1 + ".");
    }

    if (this.hobbies == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      long size2 = this.hobbies.size();
      out.writeArrayStart();
      out.setItemCount(size2);
      long actualSize2 = 0;
      for (java.lang.CharSequence e2: this.hobbies) {
        actualSize2++;
        out.startItem();
        out.writeString(e2);
      }
      out.writeArrayEnd();
      if (actualSize2 != size2)
        throw new java.util.ConcurrentModificationException("Array-size written was " + size2 + ", but element count was " + actualSize2 + ".");
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);

      this.age = in.readInt();

      this.desc = in.readString(this.desc instanceof Utf8 ? (Utf8)this.desc : null);

      if (in.readIndex() != 0) {
        in.readNull();
        this.friends = null;
      } else {
        long size0 = in.readArrayStart();
        java.util.List<ygf.serialize.avro.AvroPerson> a0 = this.friends;
        if (a0 == null) {
          a0 = new SpecificData.Array<ygf.serialize.avro.AvroPerson>((int)size0, SCHEMA$.getField("friends").schema().getTypes().get(0));
          this.friends = a0;
        } else a0.clear();
        SpecificData.Array<ygf.serialize.avro.AvroPerson> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<ygf.serialize.avro.AvroPerson>)a0 : null);
        for ( ; 0 < size0; size0 = in.arrayNext()) {
          for ( ; size0 != 0; size0--) {
            ygf.serialize.avro.AvroPerson e0 = (ga0 != null ? ga0.peek() : null);
            if (e0 == null) {
              e0 = new ygf.serialize.avro.AvroPerson();
            }
            e0.customDecode(in);
            a0.add(e0);
          }
        }
      }

      if (in.readIndex() != 0) {
        in.readNull();
        this.relatives = null;
      } else {
        long size1 = in.readMapStart();
        java.util.Map<java.lang.CharSequence,ygf.serialize.avro.AvroPerson> m1 = this.relatives; // Need fresh name due to limitation of macro system
        if (m1 == null) {
          m1 = new java.util.HashMap<java.lang.CharSequence,ygf.serialize.avro.AvroPerson>((int)size1);
          this.relatives = m1;
        } else m1.clear();
        for ( ; 0 < size1; size1 = in.mapNext()) {
          for ( ; size1 != 0; size1--) {
            java.lang.CharSequence k1 = null;
            k1 = in.readString(k1 instanceof Utf8 ? (Utf8)k1 : null);
            ygf.serialize.avro.AvroPerson v1 = null;
            if (v1 == null) {
              v1 = new ygf.serialize.avro.AvroPerson();
            }
            v1.customDecode(in);
            m1.put(k1, v1);
          }
        }
      }

      if (in.readIndex() != 0) {
        in.readNull();
        this.hobbies = null;
      } else {
        long size2 = in.readArrayStart();
        java.util.List<java.lang.CharSequence> a2 = this.hobbies;
        if (a2 == null) {
          a2 = new SpecificData.Array<java.lang.CharSequence>((int)size2, SCHEMA$.getField("hobbies").schema().getTypes().get(0));
          this.hobbies = a2;
        } else a2.clear();
        SpecificData.Array<java.lang.CharSequence> ga2 = (a2 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.CharSequence>)a2 : null);
        for ( ; 0 < size2; size2 = in.arrayNext()) {
          for ( ; size2 != 0; size2--) {
            java.lang.CharSequence e2 = (ga2 != null ? ga2.peek() : null);
            e2 = in.readString(e2 instanceof Utf8 ? (Utf8)e2 : null);
            a2.add(e2);
          }
        }
      }

    } else {
      for (int i = 0; i < 6; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
          break;

        case 1:
          this.age = in.readInt();
          break;

        case 2:
          this.desc = in.readString(this.desc instanceof Utf8 ? (Utf8)this.desc : null);
          break;

        case 3:
          if (in.readIndex() != 0) {
            in.readNull();
            this.friends = null;
          } else {
            long size0 = in.readArrayStart();
            java.util.List<ygf.serialize.avro.AvroPerson> a0 = this.friends;
            if (a0 == null) {
              a0 = new SpecificData.Array<ygf.serialize.avro.AvroPerson>((int)size0, SCHEMA$.getField("friends").schema().getTypes().get(0));
              this.friends = a0;
            } else a0.clear();
            SpecificData.Array<ygf.serialize.avro.AvroPerson> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<ygf.serialize.avro.AvroPerson>)a0 : null);
            for ( ; 0 < size0; size0 = in.arrayNext()) {
              for ( ; size0 != 0; size0--) {
                ygf.serialize.avro.AvroPerson e0 = (ga0 != null ? ga0.peek() : null);
                if (e0 == null) {
                  e0 = new ygf.serialize.avro.AvroPerson();
                }
                e0.customDecode(in);
                a0.add(e0);
              }
            }
          }
          break;

        case 4:
          if (in.readIndex() != 0) {
            in.readNull();
            this.relatives = null;
          } else {
            long size1 = in.readMapStart();
            java.util.Map<java.lang.CharSequence,ygf.serialize.avro.AvroPerson> m1 = this.relatives; // Need fresh name due to limitation of macro system
            if (m1 == null) {
              m1 = new java.util.HashMap<java.lang.CharSequence,ygf.serialize.avro.AvroPerson>((int)size1);
              this.relatives = m1;
            } else m1.clear();
            for ( ; 0 < size1; size1 = in.mapNext()) {
              for ( ; size1 != 0; size1--) {
                java.lang.CharSequence k1 = null;
                k1 = in.readString(k1 instanceof Utf8 ? (Utf8)k1 : null);
                ygf.serialize.avro.AvroPerson v1 = null;
                if (v1 == null) {
                  v1 = new ygf.serialize.avro.AvroPerson();
                }
                v1.customDecode(in);
                m1.put(k1, v1);
              }
            }
          }
          break;

        case 5:
          if (in.readIndex() != 0) {
            in.readNull();
            this.hobbies = null;
          } else {
            long size2 = in.readArrayStart();
            java.util.List<java.lang.CharSequence> a2 = this.hobbies;
            if (a2 == null) {
              a2 = new SpecificData.Array<java.lang.CharSequence>((int)size2, SCHEMA$.getField("hobbies").schema().getTypes().get(0));
              this.hobbies = a2;
            } else a2.clear();
            SpecificData.Array<java.lang.CharSequence> ga2 = (a2 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.CharSequence>)a2 : null);
            for ( ; 0 < size2; size2 = in.arrayNext()) {
              for ( ; size2 != 0; size2--) {
                java.lang.CharSequence e2 = (ga2 != null ? ga2.peek() : null);
                e2 = in.readString(e2 instanceof Utf8 ? (Utf8)e2 : null);
                a2.add(e2);
              }
            }
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










