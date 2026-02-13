import React, { useEffect, useState } from 'react';
import api from '../api';

export default function AdminView() {
  const [ownerEmail, setOwnerEmail] = useState('owner@nobroker.local');
  const [list, setList] = useState([]);

  const load = () => api.get(`/properties/owner/${ownerEmail}`).then((res) => setList(res.data));

  useEffect(() => { load(); }, []);

  const disable = async (id) => {
    await api.put(`/properties/admin/${id}/disable`);
    load();
  };

  return (
    <div>
      <h2>Admin / Super Admin Panel</h2>
      <p>Can disable any property and review all owner posts.</p>
      <input value={ownerEmail} onChange={(e) => setOwnerEmail(e.target.value)} />
      <button onClick={load}>Load Owner Properties</button>
      {list.map((p) => (
        <div className="card" key={p.id}>
          {p.title} | {p.moderationStatus} | Active: {String(p.active)}
          <button onClick={() => disable(p.id)}>Disable</button>
        </div>
      ))}
    </div>
  );
}
