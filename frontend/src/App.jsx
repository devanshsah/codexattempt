import React, { useState } from 'react';
import OwnerView from './pages/OwnerView';
import TenantView from './pages/TenantView';
import ModeratorView from './pages/ModeratorView';
import AdminView from './pages/AdminView';

const tabs = ['tenant', 'owner', 'moderator', 'admin'];

export default function App() {
  const [tab, setTab] = useState('tenant');

  return (
    <div className="container">
      <h1>NoBroker Clone (Rent Only)</h1>
      <p>Sell flow intentionally skipped. This app contains Tenant, Owner, Moderator, and Admin/Super Admin controls.</p>
      <div className="tabs">
        {tabs.map((t) => (
          <button key={t} className={tab === t ? 'active' : ''} onClick={() => setTab(t)}>{t.toUpperCase()}</button>
        ))}
      </div>
      {tab === 'tenant' && <TenantView />}
      {tab === 'owner' && <OwnerView />}
      {tab === 'moderator' && <ModeratorView />}
      {tab === 'admin' && <AdminView />}
    </div>
  );
}
