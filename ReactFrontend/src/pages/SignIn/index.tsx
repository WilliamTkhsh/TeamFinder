import { useState } from "react";
import styles from "./style.module.css";

export default function SignIn() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  return (
    <>
      <form>
      <div>
          <label htmlFor="email">E-mail</label>
          <input type="email" name="email" id="email" value={email} onChange={e=>setEmail(e.target.value)}/>
        </div>
        <div>
          <label htmlFor="password">Password</label>
          <input type="password" name="password" id="password" value={password} onChange={e=>setPassword(e.target.value)}/>
        </div>
      </form>
    </>
  );
}
