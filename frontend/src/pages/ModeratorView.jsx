import React, { useEffect, useState } from 'react';
import api from '../api';

export default function ModeratorView() {
  const [pending, setPending] = useState([]);

  const load = () => api.get('/properties/moderator/pending').then((res) => setPending(res.data));

  useEffect(() => { load(); }, []);

  const act = async (id, action) => {
    await api.put(`/properties/moderator/${id}/${action}`);
    load();
  };

  return (
    <div>
      <h2>Moderator Table</h2>
      {pending.map((p) => (
        <div className="card" key={p.id}>
          {p.title} | {p.ownerEmail}
          <button onClick={() => act(p.id, 'approve')}>Approve</button>
          <button onClick={() => act(p.id, 'reject')}>Reject</button>
        </div>
      ))}
    </div>
  );
}
