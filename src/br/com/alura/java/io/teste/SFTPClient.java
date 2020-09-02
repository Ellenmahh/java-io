package br.com.alura.java.io.teste;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SFTPClient {
 

	private	String host = "sftp.sf.prefeitura.sp.gov.br";
	private String username = "sftp-usr-24913412000180_SP156";
	private String password = "rQwxnmWzuF";
	private int port = 2022;
	private Session session = null;
	private String keyPublic = "AAAAB3NzaC1yc2EAAAADAQABAAACAQC5gmI83MZ8MIS1lGKrP8yUC3/ls30cWRbEKHPew3EaRmX8M6yi9oHVv6mH1a4kb6SeMp/n9JFZyUnnv+rTBZD3smCrBK0VyGfCWDBnmqoE2oo2pJd10VqUGYW9W16y3MhrfdhPWokOSz3VuUYGvlHtT8SNrroYcEYOug8TVfiArRgOwIrijV0srTPeCeY+0hDYYUHq01KK0JCOwUS9zQUlsPqeD+t1nnwIuqe1jiAKxJCjyp1qfSX/+xi0yme8jZQo8lBhW+IbRUk4qfE7uBQk7sBHl+6N7AUG3tKxefq0R3gj+Qz0f7AAfbKb2B1CmSPRb2cyweKe36ke+UDmonfgTkNe/Q/Xo9Zkv+VzzrD8swSqf5+g325RnhQqfA7pOCFMykbWkjmJQxc896ncJmpBSSyRYcdRTRzakON9vj87hA/WzySKjbx3DjHuPGBFKni2aLcpJOBl4rtAUPMlEqQuBLVJ1NCdy2YaHxAr5KirAyvs5opzVmEg6CQhHl2DipzI55op2HkFYz2fJ9dCGhtC17WZIG3LQ4myQmfaLiBR84XBG8qcunjAWEM0ywtD/30Vok7EMcX7O7eGuaqKwD2TjzxkiMlB3WkZBE4NtxOqFKmiyY3c1TO/ftzakRVVcXe5IwIIHnp/k311vvLFqN9qak5m7xUiM8VJ+YxlN1Z+Hw==";
	private String keyPrivate = "b29cPzOuERUENYl1NvlS5ocrCrOe+6az13mNVqVK3cKLTuC08IVVdmtVMm7yAdy1HutlYXbEhyjEJ2YHEEtcE7bCUweA4UM7o/zOUftuMEXBfyD6tj3g/hUyungw17h/Vk00gnGxh6GoXuGuFCZ2co++3fgEwKCMon5NpVrdWJLNn+uOGJqRtJX5KK5kOj1sho5JoagjFmp0tVqN86QEtiuaB40u9bJKTlAwqTDAymhSBeTApdyVwlTXf48sIVTSHF6b6nSudEEUM6ade+889PuQ5DaVZqbxGtZ2+IrZyFQRc/xnbORtlNJ2dG9F7SFnAPMSmcE9GjhhjP3MM0HMVI16qoK/rJF+jJL/mxcoFmLm5rl52ulLaDsrQgEcWJI37mmBhNpZznf0SuJCVOw9B1m8dRgK2XOMK58Paj2dlC35SWDsrMPhGNLfuKYkgYujpTAxA85B/C6+8K4JReSaBhpvy9V+p7CbQ080OXPtUKwOyr6AyPtCqEVM86dHsGcvAtJpNS1Mx2LfgqABiK/XB1ottlcgSGvz/2/+/ZroQx6yKPo3WjS4GkFHD1yU+35US3sohP77ae2OT19x6Gg2o8LeQVGCWj1uYIXMOlTSmGuuyZw4Nq2ko7FtJ9RzYVnwxMyybOCkjpA0GYuqOiUr0EPnOL4+G5v1TB6mUFvt4fGTo5q7GOi3NZ6Wccj4GgVlcXP0au7rl9YsB/veU/FAvtmROGH17nmNWUJqt8ApAGuZVlR98m9dG2rbnPOfn5DVUW1qFZIH0JbTh2eKbCdKhGLG7TtWXvZcxMK8sULF52YtiYlQrMi7rlJTlVziLbnTZqF8nUKrcxf9lWHshWjdhNTAFphJ01siSQRNRDW9tf49CoBt5+EOjh08i6hG2rOKhisQK6YiiXNbZ9Ljh+MApA0Z8IBaQ1rSjqi5SfUk6YsUF6kevjWsIotM2fRrS01txevv+6RtVVaqvvt7PuhyOBSkdVaHY0dz99XCx2PvPytm+3JzdCXiD5MQAUDBkDGpsjMx7PoyRjlLNxRURj3XMhnSNo05Ej6v8p4iy4yBGZPFrV3lSEh6WS8lIniCRRMl6Axl/Imwt0/oq851QBPoilaC1sovp3PUeyT6/xdXRUtScJHaY+miYWypO5sa4chO3ItKnmNajd3njzkmkNxGX2KlCX5XWCyuIX3+91kil23EICUOC9+G8ETTzwIpD2b3QkXnoMrMLpCry2caYMWTEBIucgvYW8Q7TbIEkqfRghxIMXmWcZPQdNXomfEY4EDORgXLZ2HbiG1pgINR5Wn/GVK9XHoE9xGmzh47cuFsjO0s4XNyjD9i7GDggnHCtHbfWZOuT5GmHTyIn3QUmdD8kuDnTwERxqtqvLNIKi3QmDgfOzovdHErNZe2ku4hUGXTKz/WbziFKJc7JeC17tOczPNrj99f+6Fi9cPNWNSkwm6DZYWdFKbXgoj7Le5rPyZZ0ruKCx5Jc4ag99hX/zXZQTzktz0cAqYsJiTEb4uaeuygCStxBSTnFBJuYJrjVdYntzj/0vBHWTdVouT2mtc4wVzPBQDVtqYHRt/cqVVvwzXmUpJryRcQKkf1P1OGgKpt1MW+Fe0TZhjsSJpy1rKvjwkAz8s9ldHA+XWhU1ofQdA4TZRCUsqA7qscFp4D1OFx1+H+ORWoywX+VCzAHVU73gkCQbdijorYs8/SmAkaa3HpfCozbrvH+zcKhfbDMygJ5wXxT6XsNRxrMAeWNK0kUQ==";
    
	public SFTPClient() {
 
    
	}
 
      public void connect() throws JSchException {
          JSch jsch = new JSch();
 
          // Uncomment the line below if the FTP server requires certificate
         //  jsch.addIdentity(keyPrivate);
  
//          session = jsch.getSession(host);
 
          // Comment the line above and uncomment the two lines below if the FTP server requires password
           session = jsch.getSession(username, host, port);
           session.setPassword(password);
 
          session.setConfig("StrictHostKeyChecking", "no");
          session.connect();
          
      }
  }